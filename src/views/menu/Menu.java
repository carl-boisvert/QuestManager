package views.menu;

import javax.swing.JMenuBar;

import controllers.QuestController;

public class Menu extends JMenuBar{

	private static final long serialVersionUID = 1L;
	public QuestMenu qMenu;
	
	public Menu(QuestController questController) {
		qMenu = new QuestMenu(this, questController);
	}

}
