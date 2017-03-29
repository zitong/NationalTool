import javax.swing.*;
import java.awt.*;

/**
 * Created by zitong on 2017/3/26.
 */
public class MainView extends JFrame {

	public MainView(){
		this.setTitle("NationalTools");
		this.setSize(800,800);
		MainMenuBar menuBar = new MainMenuBar();
		this.setJMenuBar(menuBar);

		Container con=this.getContentPane();
		GridLayout layout  = new GridLayout();
		layout.setVgap(5);
		con.setLayout(layout);

		ScanView scanView = new ScanView();
		this.add(scanView);

		ScanView scanView1 = new ScanView();
		this.add(scanView1);

	}



}
