package providers;

import org.abego.treelayout.NodeExtentProvider;

import models.Quest;
import views.QuestPanel;

public class QuestPanelExtendProvider implements NodeExtentProvider<QuestPanel>{
	
	private int maxWidth = 200;
	private int letterHeight = 20;
	private int letterWidth = 10;
	
	@Override
	public double getHeight(QuestPanel questPanel) {
		Quest quest = questPanel.getQuest();
		//return letterHeight * (quest.getQuestName().length()/letterHeight) + letterHeight;
		return 100;
	}

	@Override
	public double getWidth(QuestPanel questPanel) {
		Quest quest = questPanel.getQuest();
		return 200;
		//return (quest.getQuestName().length() < maxWidth)? quest.getQuestName().length() * letterWidth: maxWidth;
	}
}
