package views.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.QuestController;
import views.menu.listeners.QuestMenuListener;

public class QuestMenu extends JMenu{
	
	private static final long serialVersionUID = 1L;
	private JMenuItem newQuest;
	private QuestMenuListener questMenuListener;
	
	public QuestMenu(JMenuBar parent, QuestController questController) {
		super("Quest");
		questMenuListener = new QuestMenuListener(questController);
		newQuest = new JMenuItem("New Quest");
		newQuest.addMouseListener(questMenuListener);
		
		add(newQuest);
		parent.add(this);
	}

}
