package views.objectives.types;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class GetItemObjectiveView extends JPanel{
	
	private JTextField targetId;
	private JSpinner count;
	public GetItemObjectiveView() {
		MigLayout layout = new MigLayout("wrap 2");
		setLayout(layout);
		
		JLabel countLabel = new JLabel("Count: ");
		
		SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1);
		count = new JSpinner(model);
		
		JLabel itemLabel = new JLabel("Item: ");
		targetId = new JTextField(40);
		
		add(countLabel, "align right");
		add(count);
		add(itemLabel, "align right");
		add(targetId);
	}
	
	public int getCount() {
		return (int)count.getValue();
	}
	
	public String getTargetId() {
		return targetId.getText();
	}
	
	public void setCount(int value) {
		count.setValue(value);
	}
	
	public void setTargetId(String target) {
		targetId.setText(target);
	}
}
