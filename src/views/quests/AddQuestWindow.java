package views.quests;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.Controller;
import controllers.QuestController;
import models.Quest;
import models.QuestManager;
import models.objectives.Objective;
import net.miginfocom.swing.MigLayout;

public class AddQuestWindow extends QuestView{
	
	public AddQuestWindow(Controller controller, QuestManager questManager) {
		super(controller);
		this.windowTitle = "Add Quest";
		this.objectiveButtonText = "Add Objective";
		this.actionButtonText = "Create Quest";
		this.setView();
	}

}
