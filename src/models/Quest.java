package models;

import java.util.Vector;

import models.objectives.Objective;

public class Quest {

    private Vector<Objective> objectives = new Vector<Objective>();
    private String questName;
    private Vector<Quest> mustBeDone = new Vector<Quest>();
    
	public Vector<Objective> getObjectives() {
		return objectives;
	}
	public void addObjective(Objective objective) {
		this.objectives.add(objective);
	}
	public void setObjectives(Vector<Objective> objectives) {
		this.objectives = objectives;
	}
	public String getQuestName() {
		return questName;
	}
	public void setQuestName(String questName) {
		this.questName = questName;
	}
	public Vector<Quest> getMustBeDone() {
		return mustBeDone;
	}
	public void setMustBeDone(Vector<Quest> mustBeDone) {
		this.mustBeDone = mustBeDone;
	}
}
