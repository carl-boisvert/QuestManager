package views.menu.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;

import controllers.QuestController;

public class QuestMenuListener implements MouseListener{
	
	private QuestController questController;
	
	public QuestMenuListener(QuestController questController) {
		this.questController = questController;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		JMenuItem item = (JMenuItem)e.getSource();
		switch(item.getText()) {
			case "New Quest":
				questController.addQuest();
				break;
			default:
				System.out.println("Default");
		}
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
