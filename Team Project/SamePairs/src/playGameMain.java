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

public class playGameMain extends JFrame {
	private JList<String> menuJList;
	private static final String[] menu = { "Tutorial", "New Game", "Load Game", "Show Ranking", "Exit Game" };
	private JLabel nameLabel = new JLabel();
	private String name;
	private int userCnt = 0;
	private Person[] user = new Person[100];
	private int gameCount = 0;

	public static void main(String[] args){
		
		JmainTest window = new JmainTest();
		window.setTitle("GAME");
		window.menu = new Menu(window);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(300,400);
		window.setVisible(true);
		window.add(window.menu);
	}


		/*menuJList.addListSelectionListener(new ListSelectionListener() {
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

						gameCount = 0;
						for (int i = 1; i <= 3; i++) {
							// DisplayButton newGame = new DisplayButton((i + 1) * 10, name); // create
							// ButtonFrame
							// Stopwatch stopwatch = new Stopwatch(newGame);

							/*
							 * if (i != 3 && newGame.getMatchedCard() == (i + 1) * 5) continue; else if (i
							 * == 3 && newGame.getMatchedCard() == 20) return;
							 */
						//}
						/*break;

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

		);*/

	}

	/*public void startGame(int size, String name){
		if(gmaeCount != 3) {
			DisplayButton newGame = new DisplayButton(size, name);
			user[userCnt].setPersonScore(newGame.getScore());
			startGame
		}
	}*/



