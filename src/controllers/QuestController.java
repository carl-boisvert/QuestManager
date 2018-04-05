package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import enums.ObjectivesTypes;
import models.Quest;
import models.QuestManager;
import models.objectives.GetItemObjective;
import models.objectives.KillObjective;
import models.objectives.Objective;
import models.objectives.TalkToObjective;
import views.MainView;
import views.objectives.AddObjectiveWindow;
import views.objectives.EditObjectiveWindow;
import views.objectives.ObjectiveView;
import views.quests.AddQuestWindow;
import views.quests.EditQuestWindow;;

public class QuestController extends Controller implements WindowListener{
	private QuestManager questManager;
	private MainView mainView;
	private AddQuestWindow addQuestWindow;
	private EditQuestWindow editQuestWindow;
	private AddObjectiveWindow addObjectiveWindow;
	private EditObjectiveWindow editObjectiveWindow;
	private Quest quest;
	private Objective obj;
	private boolean initialized = false;
	
	public QuestController() {
		questManager = new QuestManager();
		questManager.loadQuests();
		mainView = new MainView(this, "Quest Editor", questManager);
		mainView.addWindowListener(this);
		initialized = true;
	}
	
	public void addQuest() {
		quest = new Quest();
		addQuestWindow = new AddQuestWindow(this, questManager);
		addQuestWindow.setVisible(true);
	}
	
	public void editQuest(Quest quest) {
		this.quest = quest;
		editQuestWindow = new EditQuestWindow(this, questManager, quest);
		editQuestWindow.setVisible(true);
	}
	
	public void editObjective(Objective obj) {
		this.obj = obj;
		editObjectiveWindow = new EditObjectiveWindow(this, obj);
		editObjectiveWindow.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton source = (JButton)e.getSource();
		switch(source.getText()) {
			case "Add Objective":
				addObjectiveWindow = new AddObjectiveWindow(this);
				addObjectiveWindow.setVisible(true);
				break;
			case "Create Quest":
				quest.setQuestName(addQuestWindow.getObjectiveName());
				quest.setParentQuests(addQuestWindow.getQuestDependency());
				questManager.addQuest(quest);
				addQuestWindow.dispose();
				mainView.updateUI();
				break;
			case "Create Objective":{
				Objective obj = createObjective(addObjectiveWindow);
				quest.addObjective(obj);
				addQuestWindow.addObjective(obj);
				addObjectiveWindow.dispose();
				break;
			}
			case "Edit Quest":{
				Quest questEdited = new Quest();
				questEdited.setQuestName(editQuestWindow.getObjectiveName());
				questEdited.setObjectives(editQuestWindow.getObjectives());
				questEdited.setParentQuests(editQuestWindow.getQuestDependency());
				questManager.updateQuest(editQuestWindow.getOldQuest(), questEdited);
				editQuestWindow.dispose();
				mainView.updateUI();
				break;
			}
			case "Edit Objective":{
				Objective newObj = createObjective(editObjectiveWindow);
				questManager.updateObjective(quest, obj, newObj);
				editObjectiveWindow.dispose();
				mainView.updateUI();
				break;
			}
			case "Delete Quest":{
				questManager.deleteQuest(quest);
				editQuestWindow.dispose();
				mainView.updateUI();
				break;
			}
			default:
				break;
		}
	}
	
	private Objective createObjective(ObjectiveView objWindow) {
		Objective obj = new KillObjective();
		switch(objWindow.getObjectiveType()) {
			case GetKill:{
				KillObjective objKill = new KillObjective();
				objKill.setCount(objWindow.getKillCount());
				objKill.setObjectiveType(ObjectivesTypes.GetKill);
				objKill.setTargetId(objWindow.getKillTargetId());
				obj = objKill;
				break;
			}
			case GetItem:{
				GetItemObjective itemObjective = new GetItemObjective();
				itemObjective.setObjectiveType(ObjectivesTypes.GetItem);
				itemObjective.setTargetId(objWindow.getItemTargetId());
				itemObjective.setCount(objWindow.getItemCount());
				obj = itemObjective;
				break;
			}
			case TalkTo:{
				TalkToObjective talkTo = new TalkToObjective();
				talkTo.setObjectiveType(ObjectivesTypes.TalkTo);
				talkTo.setTargetId(objWindow.getTalkToTargetId());
				obj = talkTo;
				break;
			}
		}
		obj.setObjectiveName(objWindow.getObjectiveName());
		return obj;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		if(initialized)
		{
			questManager.loadQuests();
			mainView.updateUI();
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		//Save quest to file
		questManager.saveQuests();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		//Save quest to file
		questManager.saveQuests();
	}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
}
