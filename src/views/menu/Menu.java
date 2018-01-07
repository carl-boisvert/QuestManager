package views.menu;

import javax.swing.JMenuBar;

import controllers.QuestController;

public class Menu extends JMenuBar{
	
	public QuestMenu qMenu;
	
	public Menu(QuestController questController) {
		qMenu = new QuestMenu(this, questController);
	}

}
