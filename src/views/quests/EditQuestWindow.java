package views.quests;

import javax.swing.JButton;
import javax.swing.JList;

import controllers.Controller;
import models.Quest;
import models.QuestManager;

public class EditQuestWindow extends QuestView{

	private static final long serialVersionUID = 1L;
	private Quest oldQuest;
	private JButton deleteButton;

	public EditQuestWindow(Controller controller, QuestManager questManager, Quest quest) {
		super(controller, questManager);
		oldQuest = quest;
		objectiveName.setText(quest.getQuestName());
		objectives.setListData(quest.getObjectives());
		questDependency = new JList<Quest>(quest.getParentQuests());
		this.windowTitle = "Edit Quest";
		this.objectiveButtonText = "Edit Objective";
		this.actionButtonText = "Edit Quest";
		this.setView();
		
		deleteButton = new JButton("Delete Quest");
		deleteButton.addMouseListener(controller);
		add(deleteButton, "align right");
	}

	public Quest getOldQuest() {
		return oldQuest;
	}
	
}
