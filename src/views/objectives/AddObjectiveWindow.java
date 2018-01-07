package views.objectives;

import java.awt.Color;

import controllers.Controller;
import models.Quest;

public class AddObjectiveWindow extends ObjectiveView{
	
	public AddObjectiveWindow(Controller controller) {
		super(controller);
		windowTitle = "Add Objective";
		actionButtonText = "Create Objective";
		this.setView();
	}
}
