package views.objectives;

import controllers.Controller;

public class AddObjectiveWindow extends ObjectiveView{
	
	private static final long serialVersionUID = 1L;

	public AddObjectiveWindow(Controller controller) {
		super(controller);
		windowTitle = "Add Objective";
		actionButtonText = "Create Objective";
		this.setView();
	}
}
