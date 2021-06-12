
import javax.swing.JFrame;

public class playGameMain extends JFrame {
	public static void main(String[] args){
		JmainTest window = new JmainTest();
		window.setTitle("Matching Game");
		window.menu = new Menu(window);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(265,340);
		window.setVisible(true);
		window.add(window.menu);
	}
}