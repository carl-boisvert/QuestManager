package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controllers.QuestController;
import views.QuestPanel;

public class QuestPanelListener implements MouseListener{
	
	private QuestController questController;
	
	public QuestPanelListener(QuestController questController) {
		this.questController = questController;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		QuestPanel questPanel = (QuestPanel)e.getSource();
		this.questController.editQuest(questPanel.getQuest());
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
