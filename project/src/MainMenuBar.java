import javax.swing.*;

/**
 * Created by zitong on 2017/3/26.
 */
public class MainMenuBar extends JMenuBar {
	public MainMenuBar(){
		this.addFileMenu();
		this.addFunctionMenu();
		this.addAboutMenu();
	}
	private void addFileMenu(){
		JMenu fileMenu = new JMenu("File");
		this.add(fileMenu);
	}

	private void addFunctionMenu(){
		JMenu fileMenu = new JMenu("Function");
		this.add(fileMenu);
	}

	private void addAboutMenu(){
		JMenu fileMenu = new JMenu("About");
		this.add(fileMenu);
	}
}
