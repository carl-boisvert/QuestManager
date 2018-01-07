package adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import enums.ObjectivesTypes;
import models.objectives.GetItemObjective;
import models.objectives.KillObjective;
import models.objectives.TalkToObjective;

public class ObjectiveAdapter<T> implements JsonDeserializer<T>{

	@Override
	public T deserialize(JsonElement elem, Type arg1, JsonDeserializationContext context) throws JsonParseException {
		// TODO Auto-generated method stub
		JsonObject member = (JsonObject) elem;
		ObjectivesTypes type = ObjectivesTypes.valueOf(member.get("type").getAsString());
		switch(type) {
		case GetKill:
			return context.deserialize(elem, KillObjective.class);
		case GetItem:
			return context.deserialize(elem, GetItemObjective.class);
		case TalkTo:
			return context.deserialize(elem, TalkToObjective.class);
		}
		return null;
	}

}
