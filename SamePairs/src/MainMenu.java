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
	private static final String[] menu = {"New Game", "Load Game", "Show Ranking", "Exit Game"};
	private String Name;
	public MainMenu() {
		super("MainMenu");
		setLayout(new FlowLayout());
		menuJList = new JList<String>(menu);
		menuJList.setVisibleRowCount(4);
		menuJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(menuJList));
		
		menuJList.addListSelectionListener(
			new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent event) {
					
					if(!event.getValueIsAdjusting()) {
						if(menuJList.getSelectedIndex() == 0) {
							Name = JOptionPane.showInputDialog("Enter Name");
							DisplayButton buttonFrame = new DisplayButton(40); // create ButtonFrame
							buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							buttonFrame.setSize(1500, 800); // set frame size
							buttonFrame.setVisible(true); // display frame
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
