package views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.QuestController;
import listeners.QuestPanelListener;
import models.Quest;
import models.QuestManager;
import views.menu.Menu;

public class MainView extends JFrame{
	
	private QuestManager questManager;
	private JPanel quests;
	private QuestController questController;
	
	
	public MainView(QuestController questController, String title, QuestManager questManager) {
		this.questManager = questManager;
		this.questController = questController;
		setTitle(title);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.BLACK);
		setJMenuBar(new Menu(questController));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		quests = new JPanel();
		setContentPane(quests);

		setVisible(true);
	}
	
	public void updateUI() {
		quests.removeAll();
		for (Quest quest : questManager.getQuests()) {
			QuestPanel questPanel = new QuestPanel(questController, quest);
			quests.add(questPanel);
		}
		quests.revalidate();
	}

}
