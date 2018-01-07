package views.objectives;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.Controller;
import enums.ObjectivesTypes;
import models.Quest;
import models.QuestManager;
import models.objectives.KillObjective;
import net.miginfocom.swing.MigLayout;
import views.objectives.types.GetItemObjectiveView;
import views.objectives.types.GetKillObjectiveView;
import views.objectives.types.TalkToObjectiveView;

public abstract class ObjectiveView extends JFrame{
	protected String windowTitle;
	protected String actionButtonText;
	protected JTextField objectiveName = new JTextField(40);;
	protected JComboBox objectiveTypes = new JComboBox(ObjectivesTypes.values());;
	
	protected Controller controller;
	
	//Subviews
	GetKillObjectiveView getKillView;
	GetItemObjectiveView getItemView;
	TalkToObjectiveView talkToView;
	JPanel currentPanel;
	
	public ObjectiveView(Controller controller) {
		this.controller = controller;
	}
	
	protected void setView() {
		setTitle(windowTitle);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBackground(Color.BLACK);
		
		MigLayout layout = new MigLayout("wrap 2");
		setLayout(layout);
		
		JLabel objectiveNameLabel = new JLabel("Objective Name");
		add(objectiveNameLabel, "align right");
		add(objectiveName);
		
		//Different views
		getKillView = new GetKillObjectiveView();
		currentPanel = getKillView;
		
		JLabel objectiveTypeLabel = new JLabel("Objective Type");
		objectiveTypes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				currentPanel.setVisible(false);
				remove(currentPanel);
				JComboBox type = (JComboBox)e.getSource();
				switch((ObjectivesTypes)type.getSelectedItem()) {
				case GetKill:
					getKillView = new GetKillObjectiveView();
					add(getKillView, "span2", 4);
					getKillView.setVisible(true);
					currentPanel = getKillView;
					break;
				case GetItem:
					getItemView = new GetItemObjectiveView();
					add(getItemView, "span2", 4);
					getItemView.setVisible(true);
					currentPanel = getItemView;
					break;
				case TalkTo:
					talkToView = new TalkToObjectiveView();
					add(talkToView, "span2", 4);
					talkToView.setVisible(true);
					currentPanel = talkToView;
					break;
				}
				revalidate();
			}
		});
		
		add(objectiveTypeLabel, "align right");
		add(objectiveTypes);
		
		JButton createObjective = new JButton(actionButtonText);
		createObjective.addMouseListener(controller);
		
		add(createObjective);
	}
	
	public ObjectivesTypes getObjectiveType() {
		return (ObjectivesTypes)objectiveTypes.getSelectedItem();
	}
	
	public int getKillCount() {
		return getKillView.getCount();
	}
	
	public int getItemCount() {
		return getItemView.getCount();
	}
	
	public String getObjectiveName() {
		return objectiveName.getText();
	}
	
	public String getKillTargetId() {
		return getKillView.getTargetId();
	}
	
	public String getItemTargetId() {
		return getItemView.getTargetId();
	}
	
	public String getTalkToTargetId() {
		return talkToView.getTargetId();
	}
}
