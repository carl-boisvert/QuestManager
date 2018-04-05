package views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controllers.QuestController;
import listeners.QuestPanelListener;
import models.Quest;
import net.miginfocom.swing.MigLayout;

public class QuestPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Quest quest;
	private JLabel label;
	private JButton button;
	
	public QuestPanel(QuestController questController, Quest quest) {
		this.quest = quest;
		setBorder(BorderFactory.createRaisedBevelBorder());
		MigLayout layout = new MigLayout("wrap 2");
		setLayout(layout);
		//label = new JLabel(quest.getQuestName());
		button = new JButton("Edit");
		add(new JLabel("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		add(new JLabel("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
		add(new JLabel("cccccccccccccccccccccccccccccccccc"));
		add(new JLabel("ddddddddddddddddddddddddddddddddddd"));
		add(button, "align right ");
		button.addMouseListener(new QuestPanelListener(questController));
	}

	public Quest getQuest() {
		return quest;
	}
}
