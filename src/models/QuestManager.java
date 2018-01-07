package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.security.InvalidParameterException;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import adapters.ObjectiveAdapter;
import models.objectives.Objective;

public class QuestManager {
	
	private Vector<Quest> quests = new Vector<Quest>();
	
	public void addQuest(Quest quest) {
		quests.add(quest);
	}
	
	public void updateQuest(Quest oldQuest, Quest editedQuest) {
		if(quests.contains(oldQuest)) {
			quests.set(quests.indexOf(oldQuest), editedQuest);
		} else {
			throw new InvalidParameterException("Can't find quest "+oldQuest.getQuestName());
		}
	}
	
	public void updateObjective(Quest quest, Objective oldObjective, Objective newObjective) {
		Vector<Objective> objectives = quests.get(quests.indexOf(quest)).getObjectives();
		Quest newQuest = quest;
		if(objectives.contains(oldObjective)) {
			objectives.set(objectives.indexOf(oldObjective), newObjective);
		} else {
			throw new InvalidParameterException("Can't find quest "+oldObjective.getObjectiveName());
		}
		newQuest.setObjectives(objectives);
		updateQuest(quest, newQuest);
	}
	
	public void deleteQuest(Quest quest) {
		if(!quests.remove(quest)) {
			throw new InvalidParameterException("Can't remove quest "+quest.getQuestName());
		}
	}
	
	public Vector<Quest> getQuests() {
		return quests;
	}
	
	public void saveQuests() {
		Type questType = new TypeToken<Vector<Quest>>() {}.getType();
		GsonBuilder gsonBilder = new GsonBuilder();
        gsonBilder.setPrettyPrinting();
        
        Gson gson = gsonBilder.create();
		String json = gson.toJson(quests, questType);
		System.out.println(json);
		try {
			FileWriter fileWriter = new FileWriter("quests.json");
			fileWriter.write(json);
			fileWriter.flush();
			System.out.println("Quest saved");
		} catch(IOException e) {
			System.out.println("Error while writing quests to file");
		}
		
	}
	
	public void loadQuests() {
		try {
			File questFile = new File("quests.json");
			questFile.createNewFile(); 
			FileReader fileReader = new FileReader(questFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			String json = "";
            while((line = bufferedReader.readLine()) != null) {
                json += line;
            }   

            // Always close files.
            bufferedReader.close(); 
            
            Type questType = new TypeToken<Vector<Quest>>() {}.getType();
            
            GsonBuilder gsonBilder = new GsonBuilder();
            gsonBilder.registerTypeAdapter(Objective.class, new ObjectiveAdapter<Objective>());
            gsonBilder.setPrettyPrinting();
            
            Gson gson = gsonBilder.create();
            
            quests = gson.fromJson(json, questType);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
