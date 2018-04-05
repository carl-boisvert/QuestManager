package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;

import controllers.QuestController;
import models.objectives.Objective;

public class ObjectiveListListener implements MouseListener{
	
	private QuestController questController;
	
	public ObjectiveListListener(QuestController questController) {
		this.questController = questController;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			@SuppressWarnings("unchecked")
		    JList<Objective> objectiveList = (JList<Objective>)e.getSource();
		    Objective obj = objectiveList.getSelectedValue();
		    questController.editObjective(obj);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
