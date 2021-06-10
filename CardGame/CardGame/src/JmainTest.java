import javax.swing.*;

public class JmainTest extends JFrame {
	public Menu menu;
	public Tutorial tutorial;
	public Level level1;
	public Level level2;
	public Level level3;
	public String name;

	public void change(String panelName, int size) {
		getContentPane().removeAll();
		
		if (panelName.equals("Menu")) 
			getContentPane().add(menu);
		else if (panelName.equals("Tutorial"))
			getContentPane().add(tutorial);
		else if (panelName.equals("Level1"))
			getContentPane().add(level1);
		else if (panelName.equals("Level2"))
			getContentPane().add(level2);
		else
			getContentPane().add(level3);
		
		revalidate();
		repaint();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String nowName() {
		return name;
	}
}
