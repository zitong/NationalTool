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
		GridLayout layout  = new GridLayout();
//		FlowLayout layout  = new FlowLayout();
		layout.setVgap(5);
		con.setLayout(layout);

		ScanView scanView = new ScanView();
		this.add(scanView);

		ScanView scanView1 = new ScanView();
		this.add(scanView1);

		ScanView scanView2 = new ScanView();
		this.add(scanView2);

		ScanView scanView3 = new ScanView();
		this.add(scanView3);

		ScanView scanVie4 = new ScanView();
		this.add(scanVie4);
	}



}
