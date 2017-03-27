import javax.swing.*;
import java.awt.*;

/**
 * Created by zitong on 2017/3/26.
 */
public class MainView extends JFrame {

	public MainView(){
		this.setTitle("NationalTools");
		this.setSize(500,500);
		MainMenuBar menuBar = new MainMenuBar();
		this.setJMenuBar(menuBar);

		Container con=this.getContentPane();
		con.setLayout(new GridLayout());

		ScanView scanView = new ScanView();
		this.add(scanView);
	}



}
