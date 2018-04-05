package models;

import java.util.UUID;
import java.util.Vector;

import models.objectives.Objective;

public class Quest {

	private UUID id;
    private Vector<Objective> objectives = new Vector<Objective>();
    private String questName;
    private Vector<Quest> parentQuests = new Vector<Quest>();
    
    public Quest() {
    		id = UUID.randomUUID();
    }
    
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
	public Vector<Quest> getParentQuests() {
		return parentQuests;
	}
	public void setParentQuests(Vector<Quest> parentQuests) {
		this.parentQuests = parentQuests;
	}
	public UUID getId() {
		return id;
	}
}
