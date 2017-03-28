import javax.swing.*;
import java.awt.*;

/**
 * Created by zitong on 2017/3/27.
 */
public class ScanView extends JPanel{
	private JLabel titleLabel;
	private JList list;
	public ScanView(){
		super();
		VerticalFlowLayout layout = new VerticalFlowLayout();
		layout.hfill = true;
		this.setLayout(layout);

		this.titleLabel = new JLabel("提取结果（0/0）");
		this.add(titleLabel);

		String sports[]={"足球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球","排球","乒乓球","篮球"};
		this.list = new JList(sports);
//		this.list.setPreferredSize(new java.awt.Dimension(192, 800));

		JScrollPane scrollPane = new JScrollPane(this.list);
//		scrollPane.setSize(300, 1000);
		scrollPane.setPreferredSize(new java.awt.Dimension(192, 400));
		this.add(scrollPane);
	}

}
