package views;

import java.util.Vector;

import javax.swing.JPanel;

import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.util.DefaultConfiguration;
import org.abego.treelayout.util.DefaultTreeForTreeLayout;

import controllers.QuestController;
import models.Quest;
import models.QuestManager;
import providers.QuestPanelExtendProvider;

public class QuestTreeView extends JPanel{

	private static final long serialVersionUID = 1L;
	private QuestManager questManager; 
	private QuestController controller;
	
	private double gapBetweenLevels = 50;
	private double gapBetweenNodes = 10;
	
	DefaultTreeForTreeLayout<QuestPanel> treeData = null;
	DefaultConfiguration<QuestPanel> configuration;
	TreeLayout<QuestPanel> treeLayout;
	private QuestController questController;
	
	public QuestTreeView(QuestController controller, QuestManager questManager) {
		this.questManager = questManager;
		this.questController = controller;
		updateUI();
	}

	private void createTree(Vector<Quest> quests) {
		QuestPanel parentQuestPanel = new QuestPanel(controller, quests.get(0));
		for (Quest quest : quests) {
			QuestPanel questPanel = new QuestPanel(controller, quest);
			//Put them in relation to one another
			if(quests.indexOf(quest) == 0) {
				treeData = new DefaultTreeForTreeLayout<QuestPanel>(parentQuestPanel);
			} else {
				treeData.addChild(parentQuestPanel, questPanel);
			}
		}
		
	}
	

	public void updateUI() {
		if(this.questManager != null)
		{
			this.removeAll();
			Vector<Quest> quests = questManager.getQuests();

			createTree(quests);
			TreeForTreeLayout<QuestPanel> tree = treeData;
			configuration = new DefaultConfiguration<QuestPanel>(gapBetweenLevels, gapBetweenNodes);
			QuestPanelExtendProvider provider = new QuestPanelExtendProvider();
			treeLayout = new TreeLayout<QuestPanel>(tree, provider, configuration);
			
			QuestTreePanel questTreePane = new QuestTreePanel(treeLayout, questController);
			questTreePane.updateUi();
			add(questTreePane);
		}
	}

}
