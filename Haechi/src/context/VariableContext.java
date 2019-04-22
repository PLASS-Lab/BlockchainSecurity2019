package context;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import node.VariableDeclaration;
import util.Position;

public class VariableContext {
	public List<VariableDeclaration> getAllVariables() {
		return VariableDeclaration.getRegistry();
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray getAllVariableINFO() {
		Position position = new Position();
		
		VariableContext variableContext = new VariableContext();
		List<VariableDeclaration> allVariableContext = variableContext.getAllVariables();
		
		JSONArray variableArray;
		JSONObject variableINFO = new JSONObject();
		
		variableArray = new JSONArray();
		for(VariableDeclaration variableDeclaration : allVariableContext) {
			variableINFO = new JSONObject();
			variableINFO.put("id", variableDeclaration.getId());
			variableINFO.put("isStateVariable", variableDeclaration.getStateVariable());
			variableINFO.put("name", variableDeclaration.getName());
			variableINFO.put("type", variableDeclaration.getRealTypeName());
			variableINFO.put("line", position.getLineNumber(variableDeclaration.getCharacterCount()));
			variableArray.add(variableINFO);
		}
		
		return variableArray;
	}
	
	public List<VariableDeclaration> getAllStateVariables() {
		List<VariableDeclaration> stateVariables = new ArrayList<VariableDeclaration>();
		
		for(VariableDeclaration variable : VariableDeclaration.getRegistry()) {
			if((boolean) variable.getStateVariable()) 
				stateVariables.add(variable);
		}
		return stateVariables;
	}
	
	public List<VariableDeclaration> getAllStorageVariables() {
		List<VariableDeclaration> storageVariables = new ArrayList<VariableDeclaration>();
		
		for(VariableDeclaration variable : VariableDeclaration.getRegistry()) {
			if(variable.getStorageLocation().equals("storage")) 
				storageVariables.add(variable);
		}
		return storageVariables;
	}
	
	public List<VariableDeclaration> getAllMemoryVariables() {
		List<VariableDeclaration> memoryVariables = new ArrayList<VariableDeclaration>();
		
		for(VariableDeclaration variable : VariableDeclaration.getRegistry()) {
			if(variable.getStorageLocation().equals("memory")) 
				memoryVariables.add(variable);
		}
		return memoryVariables;
	}
	
	public String getVariableNameForId(Object id) {
		for(VariableDeclaration variable : VariableDeclaration.getRegistry()) {
			if(variable.getId() == id)
				return variable.getName();
		}
		return "Error";
	}
	
	public List<String> getAllVariablesNames() {
		List<String> variableNames = new ArrayList<String>();
		for(VariableDeclaration variable : VariableDeclaration.getRegistry()) {
			variableNames.add(variable.getName());
		}
		return variableNames;
	}
}

