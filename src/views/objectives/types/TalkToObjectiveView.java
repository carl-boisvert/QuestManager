package views.objectives.types;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class TalkToObjectiveView extends JPanel{
	
	private JTextField targetId;

	public TalkToObjectiveView() {
		MigLayout layout = new MigLayout("wrap 2");
		setLayout(layout);
		
		JLabel targetLabel = new JLabel("Target id: ");
		targetId = new JTextField(40);
		
		add(targetLabel, "align right");
		add(targetId);
	}
	
	public String getTargetId() {
		return targetId.getText();
	}
	
	public void setTargetId(String target) {
		targetId.setText(target);
	}
}
