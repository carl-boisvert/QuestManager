package views.quests;

import java.awt.Color;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import controllers.Controller;
import controllers.QuestController;
import listeners.ObjectiveListListener;
import models.Quest;
import models.QuestManager;
import models.objectives.Objective;
import net.miginfocom.swing.MigLayout;

public abstract class QuestView extends JFrame {

	private static final long serialVersionUID = 1L;
	protected JTextField objectiveName = new JTextField(40);
	protected DefaultListModel<Objective> objectivesModel = new DefaultListModel<Objective>();
	protected JList<Objective> objectives = new JList<Objective>(objectivesModel);
	protected JList<Quest> questDependency = new JList<Quest>();
	
	private Controller controller;
	protected String windowTitle;
	protected String objectiveButtonText;
	protected String actionButtonText;
	protected QuestManager questManager;
	
	public QuestView(Controller controller, QuestManager questManager) {
		this.controller = controller;
		this.questManager = questManager;
	}
	
	protected void setView() {
		setTitle(windowTitle);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBackground(Color.BLACK);
		MigLayout layout = new MigLayout("wrap 2");
		setLayout(layout);
		
		//Quest name
		JLabel name = new JLabel("Name:");
		add(name, "align right");
		add(objectiveName, "align left");
		
		
		//Objectives list
		JLabel objectivesLabel = new JLabel("Objective: ");
		JButton addObjectives = new JButton(objectiveButtonText);
		addObjectives.addMouseListener(controller);
		add(objectivesLabel, "align right");
		add(addObjectives, "align left");
		add(objectives, "span 2");
		objectives.addMouseListener(new ObjectiveListListener((QuestController)controller));
		
		
		//Parent Quest
		JLabel parent = new JLabel("Dependend on: ");
		JComboBox<Quest> quests = new JComboBox<Quest>();
		JButton addDependency = new JButton("Add Dependency");
		
		add(parent, "align right");
		add(quests, "align left");
		add(addDependency, "align right");
		add(questDependency, "align left");
		
		JButton createQuest = new JButton(actionButtonText);
		createQuest.addMouseListener(controller);
		
		add(createQuest);
	}

	public String getObjectiveName() {
		return objectiveName.getText();
	}

	public Vector<Objective> getObjectives() {
		Vector<Objective> vObjectives = new Vector<Objective>();
		for(int i = 0; i<objectives.getModel().getSize(); i++) {
			vObjectives.add(objectives.getModel().getElementAt(i));
		}
		return vObjectives;
	}
	
	public void addObjective(Objective obj) {
		objectivesModel.addElement(obj); 
		objectives.setModel(objectivesModel);
		revalidate();
	}

	public Vector<Quest> getQuestDependency() {
		Vector<Quest> vQuestDependency = new Vector<Quest>();
		for(int i = 0; i<questDependency.getModel().getSize(); i++) {
			vQuestDependency.add(questDependency.getModel().getElementAt(i));
		}
		return vQuestDependency;
	}
}
