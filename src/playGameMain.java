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
	//private Person[] user = new Person[100];
	private int gameCount = 0;

	public static void main(String[] args){
		
		JmainTest window = new JmainTest();
		window.setTitle("GAME");
		window.menu = new Menu(window);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(265,340);
		window.setVisible(true);
		window.add(window.menu);
	}
}