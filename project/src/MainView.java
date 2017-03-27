import javax.swing.*;

/**
 * Created by zitong on 2017/3/26.
 */
public class MainView extends JFrame {

	public MainView(){
		this.setTitle("NationalTools");
		this.setSize(500,500);
		MainMenuBar menuBar = new MainMenuBar();
		this.setJMenuBar(menuBar);
	}

}
