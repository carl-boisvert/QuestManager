package models.objectives;

import enums.ObjectivesTypes;

public abstract class Objective{


    protected String objectiveName;
    protected ObjectivesTypes type;

    public String getObjectiveName(){
        return objectiveName;
    }

    public void setObjectiveName(String objName)
    {
        objectiveName = objName;
    }

    public void setObjectiveType(ObjectivesTypes type){
        this.type = type;
    }

    public ObjectivesTypes getObjectiveType()
    {
        return type;
    }
}

