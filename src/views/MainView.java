package views;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controllers.QuestController;
import models.QuestManager;
import views.menu.Menu;

public class MainView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private QuestManager questManager;
	private JPanel questsPanel;
	private QuestController questController;
	
	
	public MainView(QuestController questController, String title, QuestManager questManager) {
		this.questManager = questManager;
		this.questController = questController;
		setTitle(title);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setJMenuBar(new Menu(questController));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		if(this.questManager.getQuests().size() > 0) {
			questsPanel = new QuestTreeView(this.questController, questManager);
			setContentPane(questsPanel);
		}

		setVisible(true);
	}
	
	public void updateUI() {
		if(questsPanel != null) {
			questsPanel.removeAll();
			questsPanel.updateUI();
			questsPanel.revalidate();
		}
	}

}
