import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zitong on 2017/3/27.
 * 用来提取出代码中的中文字符串
 */
public class ScanView extends JPanel implements ActionListener{
	private JLabel titleLabel;
	private JList<String> list;
	DefaultListModel dlm;
	private static final String OPEN_COMMAND="open";
	private static final String EXPORT_COMMAND="export";
	public ScanView(){
		super();
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		//title
		this.titleLabel = new JLabel("提取结果（0/0）");
		this.add(titleLabel, BorderLayout.NORTH);
		//list
		this.list = new JList<String>();
		this.dlm = new DefaultListModel();
		this.list.setModel(this.dlm);
		JScrollPane scrollPane = new JScrollPane(this.list);
		this.add(scrollPane, BorderLayout.CENTER);
		//按钮
		JPanel btnPanel = new JPanel(new FlowLayout());
		btnPanel.setSize(20, 50);
		this.add(btnPanel, BorderLayout.SOUTH);

		JButton openBtn = new JButton("打开");
		openBtn.addActionListener(this);
		openBtn.setActionCommand("open");
		btnPanel.add(openBtn);

		JButton exportBtn = new JButton("导出");
		exportBtn.addActionListener(this);
		exportBtn.setActionCommand("export");
		btnPanel.add(exportBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()){
			case OPEN_COMMAND:
				this.openButtonAction();
				break;
			case EXPORT_COMMAND:
				this.exportButtonAction();
				break;
			default:
				break;
		}
	}

	/**
	 * 打开按钮事件
	 */
	private void openButtonAction(){
		System.out.println("open");
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = chooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String dirPath = chooser.getSelectedFile().getPath();
			System.out.println("Select Dir Path:"+dirPath);

			ScanDirText scaner = new ScanDirText(dirPath,this);
			scaner.start();
		}
	}

	public synchronized void addString(String str) {
		this.dlm.addElement(str);

	}

	public void setTitleNum(int num){
		this.titleLabel.setText("提取结果:"+num);
	}

	/**
	 * 导出按钮事件
	 */
	public void exportButtonAction() {
		this.dlm.addElement("asdfasdfasdf");
		System.out.println("export");
	}

}
