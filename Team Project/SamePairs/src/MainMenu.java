/*import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class MainMenu extends JFrame {
	private JList<String> menuJList;
	private static final String[] menu = { "Tutorial", "New Game", "Load Game", "Show Ranking", "Exit Game" };
	JLabel nameLabel = new JLabel();
	private String name;
	private int userCnt = 0;
	Person[] user = new Person[100];

	public MainMenu() {
		super("MainMenu");
		setLayout(new FlowLayout());
		menuJList = new JList<String>(menu);
		menuJList.setVisibleRowCount(5);
		menuJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(menuJList));

		menuJList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {

				if (!event.getValueIsAdjusting()) { // not to display twice
					switch (menuJList.getSelectedIndex()) {
					case 0:
						DisplayButton tutorial = new DisplayButton(4, " "); // create ButtonFrame, fix : change to loop
						return;
					case 1:
						name = JOptionPane.showInputDialog("Enter Name"); // fix : only when user choose ok
						if (name == null)
							return;
						user[++userCnt] = new Person();
						user[userCnt].setPerson(name);
						for (int i = 1; i <= 3; i++) {
							DisplayButton newGame = new DisplayButton((i + 1) * 10, name); // create ButtonFrame
	                        Stopwatch stopwatch = new Stopwatch(newGame);

							user[userCnt].setPersonScore(newGame.getScore());
							if (i != 3 && newGame.getMatchedCard() == (i + 1) * 5)
								continue;
							else if (i == 3 && newGame.getMatchedCard() == 20)
								return;
						}
						break;

					case 2:
						String name2 = JOptionPane.showInputDialog("Enter Name");
						int i = 1, j = 0, lastLevel = 0, userNum = 0;
						for (; i <= userCnt; i++) {
							if (name2.equals(user[i].getPersonName())) {
								j = 1;
								userNum = i;
								lastLevel = user[i].getPersonHighLevel();
								break;
							}
						}
						if (j == 1) {
							for (i = lastLevel; i <= 3; i++) {
								DisplayButton loadedGame = new DisplayButton((i + 1) * 10, name2);
								user[userNum].setPersonScore(loadedGame.getScore());
							}
						}
					case 3:

					case 4:

					}
				}
			}
		}

		);

	}
	 class Stopwatch implements ActionListener{

	      JFrame frame = new JFrame();
	      JLabel timeLabel = new JLabel();
	      int elapsedTime=0;
	      int seconds=0;
	      int minutes=0;
	      int hours=0;
	      
	      String seconds_string = String.format("%02d", seconds);
	      String minutes_string = String.format("%02d", minutes);
	      String hours_string = String.format("%02d", hours);
	      Stopwatch(DisplayButton e){
	         timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	         timeLabel.setBounds(100, 100, 200, 100);
	         timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
	         timeLabel.setBorder(BorderFactory.createBevelBorder(1));
	         timeLabel.setOpaque(true);
	         //timeLabel.setHorizontalAlignment(JTextField.EAST);
	         timeLabel.setVerticalAlignment(JTextField.CENTER);
	         
	         e.add(timeLabel);
	         //e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         //e.setSize(420, 420);
	         //e.setLayout();
	         //e.setVisible(true);
	         
	      }
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	 }
}
