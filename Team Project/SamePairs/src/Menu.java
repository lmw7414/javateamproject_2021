import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Menu extends JPanel{
	private JList<String> menuJList;
	private JmainTest window;
	private static final String[] menu = { "Tutorial", "New Game", 
			"Load Game", "Show Ranking", "Exit Game" };
	private int userCnt = 0;
	private String name;
	private Person[] user = new Person[100];
	
	public Menu(JmainTest window) {
		this.window = window;
		
		setLayout(new FlowLayout());
		menuJList = new JList<String>(menu);
		menuJList.setVisibleRowCount(5);
		menuJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(menuJList);		//new JScrollPane(menuJList));
		
		menuJList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {

				if (!event.getValueIsAdjusting()) { // not to display twice
					switch (menuJList.getSelectedIndex()) {
					case 0:
						window.tutorial = new Tutorial(window);
						window.change("Tutorial", 0); // create ButtonFrame, fix : change to loop
						return;
					case 1:
						name = JOptionPane.showInputDialog("Enter Name"); // fix : only when user choose ok
						if (name == null)
							return;
						user[++userCnt] = new Person();
						user[userCnt].setPerson(name);
						Level newGame = new Level(20, user[userCnt]);
						
						break;

					/*case 2:
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
					case 3:*/
					case 4:
						System.out.print(user[userCnt - 1].getPersonScore());
						System.out.print(user[userCnt].getPersonScore());
						System.out.print(user[userCnt - 1].getPersonName());
						System.out.print(user[userCnt].getPersonName());
						
						System.exit(0);

					}
				}
			}
		}

		);

	}
	
}