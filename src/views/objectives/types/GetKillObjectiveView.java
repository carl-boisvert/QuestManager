package views.objectives.types;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

public class GetKillObjectiveView extends JPanel{

	private static final long serialVersionUID = 1L;
	private JSpinner count;
	private JTextField targetId;

	public GetKillObjectiveView() {
		MigLayout layout = new MigLayout("wrap 2");
		setLayout(layout);
		
		JLabel countLabel = new JLabel("Count: ");
		
		SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1);
		count = new JSpinner(model);
		
		add(countLabel, "align right");
		add(count);
		
		JLabel targetLabel = new JLabel("Target Id: ");
		targetId = new JTextField(40);
		
		add(targetLabel, "align right");
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
