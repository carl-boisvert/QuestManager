package views.quests;

import controllers.Controller;
import models.QuestManager;

public class AddQuestWindow extends QuestView{
	
	private static final long serialVersionUID = 1L;

	public AddQuestWindow(Controller controller, QuestManager questManager) {
		super(controller, questManager);
		this.windowTitle = "Add Quest";
		this.objectiveButtonText = "Add Objective";
		this.actionButtonText = "Create Quest";
		this.setView();
	}

}
