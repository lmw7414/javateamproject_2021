import javax.swing.*;

public class Frame extends JFrame {
	
	public Frame(String string){
		setTitle(string);	//Title
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);	//â ũ�� �缳�� X
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	//â ��� ��ġ
		setVisible(true);
	}
}
