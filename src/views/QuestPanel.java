package views;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.QuestController;
import listeners.QuestPanelListener;
import models.Quest;

public class QuestPanel extends JPanel{
	private Quest quest;
	
	public QuestPanel(QuestController questController, Quest quest) {
		this.quest = quest;
		setBorder(BorderFactory.createRaisedBevelBorder());
		add(new JLabel(quest.getQuestName()));
		addMouseListener(new QuestPanelListener(questController));
	}

	public Quest getQuest() {
		return quest;
	}
}
