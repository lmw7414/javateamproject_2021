import javax.swing.*;

public class GameFrame extends JFrame{
	public Level level1;
	public Level level2;
	public Level level3;
	
	public void change(String panelName, int size) {
		getContentPane().removeAll();
		
		if (panelName.equals("Level1"))
			getContentPane().add(level1);
		else if (panelName.equals("Level2"))
			getContentPane().add(level2);
		else if (panelName.equals("Level3"))
			getContentPane().add(level3);
		else if (panelName.equals("end"))
			dispose();
		
		revalidate();
		repaint();
	}
}
