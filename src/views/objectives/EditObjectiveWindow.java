package views.objectives;

import controllers.Controller;
import models.objectives.GetItemObjective;
import models.objectives.KillObjective;
import models.objectives.Objective;
import models.objectives.TalkToObjective;

public class EditObjectiveWindow extends ObjectiveView{

	private static final long serialVersionUID = 1L;

	public EditObjectiveWindow(Controller controller, Objective obj) {
		super(controller);
		windowTitle = "Edit Objective";
		actionButtonText = "Edit Objective";
		objectiveName.setText(obj.getObjectiveName());
		this.setView();
		objectiveTypes.setSelectedItem(obj.getObjectiveType());
		
		switch(obj.getObjectiveType()) {
			case GetKill:{
				KillObjective killObj = (KillObjective)obj;
				getKillView.setCount(killObj.getCount());
				getKillView.setTargetId(killObj.getTargetId());
				break;
			}
			case GetItem:{
				GetItemObjective getItemObj = (GetItemObjective)obj;
				getItemView.setCount(getItemObj.getCount());
				getItemView.setTargetId(getItemObj.getTargetId());
				break;
			}
			case TalkTo:{
				TalkToObjective talkToObj = (TalkToObjective)obj;
				talkToView.setTargetId(talkToObj.getTargetId());
				break;
			}
		}
	}

}
