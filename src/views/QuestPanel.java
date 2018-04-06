package views;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.QuestController;
import models.Quest;
import net.miginfocom.swing.MigLayout;

public class QuestPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Quest quest;
	private JLabel label;
	private JButton button;
	
	public QuestPanel(QuestController questController, Quest quest) {
		this.quest = quest;
	}

	public Quest getQuest() {
		return quest;
	}
}
