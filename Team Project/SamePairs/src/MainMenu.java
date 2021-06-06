import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;

public class MainMenu extends JFrame {
	private JList<String> menuJList;
	private static final String[] menu = {"Tutorial", "New Game", "Load Game", "Show Ranking", "Exit Game"};
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
		
		menuJList.addListSelectionListener(
			new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent event) {
					
					if(!event.getValueIsAdjusting()) { // not to display twice
						switch (menuJList.getSelectedIndex()) {
							case 1:
								name = JOptionPane.showInputDialog("Enter Name"); // fix : only when user choose ok
								user[++userCnt] = new Person();
								user[userCnt].setPerson(name);
								DisplayButton level1 = new DisplayButton(20); // create ButtonFrame, fix : change to loop
								level1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								level1.setSize(1400, 800); // set frame size
								level1.setVisible(true); // display frame
								user[userCnt].setPersonScore(level1.getScore());
								break;
							
							case 2:
								String name2 = JOptionPane.showInputDialog("Enter Name");
								int i = 0, j = 0, lastLevel = 0;
								for (; i <= userCnt; i++) {
									if (name2.equals(user[i].getPersonName())) {
										j = 1;
										lastLevel = user[i].getPersonHighLevel();
									}
								}
								/*if (j != 1) {
									for (i = 0; i<)
									DisplayButton loadedGame = new DisplayButton((lastLevel + 1)*10);
									
								}*/
						}
					}
				}					
			}

		);
	}
	public String getName() {
		return Name;
	}
}
