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
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.TRAILING);
		this.setLayout(layout);

		this.titleLabel = new JLabel("提取结果（0/0）");
		this.add(titleLabel);

		String sports[]={"足球","排球","乒乓球","篮球"};
		this.list = new JList(sports);
		this.add(list);
	}

}
