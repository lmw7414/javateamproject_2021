import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame {
	private JList<String> menuJList;
	private static final String[] menu = {"Tutorial", "New Game", "Load Game", "Show Ranking", "Exit Game"};
	JLabel nameLabel = new JLabel();
	JLabel levelLabel = new JLabel();
	private String name;
	private int level=1;
	private int userCnt = 0;
	Person[] user = new Person[100];
	
	
	public MainMenu() {
		super("MainMenu");
		setLayout(new FlowLayout());
		menuJList = new JList<String>(menu);
		menuJList.setVisibleRowCount(5);
		menuJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(menuJList));		

		menuJList.addListSelectionListener(
			new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent event) {
					
					if(!event.getValueIsAdjusting()) { // not to display twice
						switch (menuJList.getSelectedIndex()) {
						case 0 : 
							DisplayButton tutorial = new DisplayButton(4); // create ButtonFrame, fix : change to loop
							tutorial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							tutorial.setSize(1400, 800); // set frame size
							tutorial.setVisible(true); // display frame
							user[userCnt].setPersonScore(tutorial.getScore());							
							
							break;
						case 1 :
							name = JOptionPane.showInputDialog("Enter Name"); // fix : only when user choose ok
							
							if(name == null)
								return;
							user[++userCnt] = new Person();
							user[userCnt].setPerson(name);
							for(int i = 1 ; i <= 3 ; i++) {
								DisplayButton newGame = new DisplayButton((i + 1)*10); // create ButtonFrame, fix : change to loop
								newGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								newGame.setSize(1400, 800); // set frame size
								newGame.setVisible(true); // display fram
								String name2= "Name : "+ name;
								nameLabel.setText(name2);
								nameLabel.setBounds(100, 100, 200, 100);
								String level2= "Level : "+ level;
								levelLabel.setText(level2);
								levelLabel.setBounds(100, 100, 200, 100);
								newGame.add(nameLabel);
								Stopwatch stopwatch = new Stopwatch(newGame);
								stopwatch.timer.start();
								newGame.add(levelLabel);
								level=level+1;
								user[userCnt].setPersonScore(newGame.getScore());
							}
							break;
							
						case 2 :
							String name2 = JOptionPane.showInputDialog("Enter Name");
							int i = 1, j = 0, lastLevel = 0, userNum = 0;
							for (; i <= userCnt; i++) {
								if (name2.equals(user[i].getPersonName())) {
									j = 1; userNum = i;
									lastLevel = user[i].getPersonHighLevel();
									break;
								}
							}
							if (j == 1) {
								for (i = lastLevel; i <= 3; i++) {
									DisplayButton loadedGame = new DisplayButton((i + 1)*10);
									loadedGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									loadedGame.setSize(1400, 800); // set frame size
									loadedGame.setVisible(true); // display frame
									user[userNum].setPersonScore(loadedGame.getScore());
								}
							}
						case 3 :
							
						case 4 :
							

						}
					}
				}					
			}

		);
	}
	class Stopwatch implements ActionListener{

		JFrame frame = new JFrame();
		JLabel timeLabel = new JLabel();
		JButton stopButton = new JButton("STOP");
		int elapsedTime=0;
		int seconds=0;
		int minutes=0;
		int hours=0;
		boolean stoped=false;
		String seconds_string = String.format("%02d", seconds);
		String minutes_string = String.format("%02d", minutes);
		String hours_string = String.format("%02d", hours);
		
		Timer timer = new Timer(1000, new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				elapsedTime=elapsedTime+1000;
				hours=(elapsedTime/3600000);
				minutes=(elapsedTime/60000)%60;
				seconds=(elapsedTime/1000)%60;
				seconds_string = String.format("%02d", seconds);
				minutes_string = String.format("%02d", minutes);
				hours_string = String.format("%02d", hours);
				timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
				
				stopButton.setBounds(100,200,100,50);
				stopButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
				stopButton.setFocusable(false);
				stopButton.addActionListener(this);
			}
		});
		Stopwatch(DisplayButton e){
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
			timeLabel.setBounds(100, 100, 200, 100);
			timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
			timeLabel.setBorder(BorderFactory.createBevelBorder(1));
			timeLabel.setOpaque(true);
			timeLabel.setHorizontalAlignment(JTextField.CENTER);
			
			e.add(timeLabel);
			e.add(stopButton);
			//e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//e.setSize(420, 420);
			//e.setLayout();
			//e.setVisible(true);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==stopButton) {
				if(stoped==false) {
					stoped=true;
					stopButton.setText("START");
					timer.stop();
				}
				else {
					stoped=false;
					stopButton.setText("STOP");
					timer.start();
				}
			}
				
			
		}

		
	}
}
