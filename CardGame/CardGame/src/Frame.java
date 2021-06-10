import javax.swing.*;

public class Frame extends JFrame {
	
	public Frame(String string){
		setTitle(string);	//Title
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);	//창 크기 재설정 X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	//창 가운데 위치
		setVisible(true);
	}
}
