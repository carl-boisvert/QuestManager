package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.TreeLayout;

import controllers.QuestController;
import listeners.QuestPanelListener;

public class QuestTreePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	TreeLayout<QuestPanel> treeLayout;
	QuestController questController;
	
	public QuestTreePanel(TreeLayout<QuestPanel> treeLayout, QuestController questController) {
		this.treeLayout = treeLayout;
		this.questController = questController;
		setLayout(null);
		
		Dimension size = treeLayout.getBounds().getBounds().getSize();
		setPreferredSize(size);
	}
	
	private TreeForTreeLayout<QuestPanel> getTree() {
		return treeLayout.getTree();
	}
	
	private Iterable<QuestPanel> getChildren(QuestPanel parent) {
		return getTree().getChildren(parent);
	}

	private Rectangle2D.Double getBoundsOfNode(QuestPanel node) {
		return treeLayout.getNodeBounds().get(node);
	}
	
	private void paintEdges(Graphics g, QuestPanel parent) {
		if (!getTree().isLeaf(parent)) {
			Rectangle2D.Double b1 = getBoundsOfNode(parent);
			double x1 = b1.getCenterX();
			double y1 = b1.getCenterY();
			for (QuestPanel child : getChildren(parent)) {
				Rectangle2D.Double b2 = getBoundsOfNode(child);
				g.drawLine((int) x1, (int) (y1+(b2.height/2)), (int) b2.getCenterX(),
						(int) (b2.getCenterY()-(b2.height/2)));

				paintEdges(g, child);
			}
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);

		paintEdges(g, getTree().getRoot());
	}
	
	public void updateUi()
	{
		for (QuestPanel questPanel : treeLayout.getNodeBounds().keySet()) {
			Rectangle2D.Double position = getBoundsOfNode(questPanel);
			questPanel.setBackground(Color.ORANGE);
			JLabel jlabel = new JLabel(questPanel.getQuest().getQuestName());
			questPanel.add(jlabel);
			add(questPanel);
			questPanel.addMouseListener(new QuestPanelListener(questController));
			questPanel.setBounds((int)position.x, (int)position.y, (int)position.width - 1, (int)position.height - 1);
		}
	}
}
