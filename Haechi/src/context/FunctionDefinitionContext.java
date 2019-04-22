package context;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import node.AST;
import node.FunctionDefinition;
import util.Position;

public class FunctionDefinitionContext {
	public List<FunctionDefinition> getAllFunctionDefinitions() {
		return FunctionDefinition.getRegistry();
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray getAllFunctionDefinitionINFO() {
		Position position = new Position();
		
		FunctionDefinitionContext functionDefinitionContext = new FunctionDefinitionContext();
		List<FunctionDefinition> allFunctionDefinitionContext = functionDefinitionContext.getAllFunctionDefinitions();
		
		JSONArray functionDefinitionArray;
		JSONObject functionDefinitionINFO = new JSONObject();
		
		functionDefinitionArray = new JSONArray();
		for(FunctionDefinition functionDefinition : allFunctionDefinitionContext) {
			functionDefinitionINFO = new JSONObject();
			functionDefinitionINFO.put("id", functionDefinition.getId());
			functionDefinitionINFO.put("kind", functionDefinition.getKind());
			functionDefinitionINFO.put("name", functionDefinition.getName());
			functionDefinitionINFO.put("visibility", functionDefinition.getVisibility());
			functionDefinitionINFO.put("line", position.getLineNumber(functionDefinition.getCharacterCount()));
			functionDefinitionArray.add(functionDefinitionINFO);
		}
		
		return functionDefinitionArray;
	}
	
	public List<String> getAllConstructors() {
		List<String> constructors = new ArrayList<String>();
		
		for(FunctionDefinition functionDefinition : FunctionDefinition.getRegistry()) {
			if((boolean) functionDefinition.getIsConstructor()) 
				constructors.add(functionDefinition.getName());
		}
		return constructors;
	}
	
	public List<String> getAllFuncionDefinitionNames() {
		List<String> functionDefinitionNames = new ArrayList<String>();
		
		for(int i=0; i<getAllFunctionDefinitions().size(); i++) {
			String name = getAllFunctionDefinitions().get(i).getName();
			functionDefinitionNames.add(name);
		}
		
		return functionDefinitionNames;
	}
	
	public List<String> getAllFunctionDefinitionsWithExternalVisibility() {
		List<String> functionDefinitions = new ArrayList<String>();
		return functionDefinitions;
	}
	
	public List<String> getAllFunctionDefinitionsWithPublicVisibility() {
		List<String> functionDefinitions = new ArrayList<String>();
		return functionDefinitions;
	}
	
	public List<String> getAllFunctionDefinitionsWithInternalVisibility() {
		List<String> functionDefinitions = new ArrayList<String>();
		return functionDefinitions;
	}
	
	public List<String> getAllFunctionDefinitionsWithPrivateVisibility() {
		List<String> functionDefinitions = new ArrayList<String>();
		return functionDefinitions;
	}
	
	public List<String> getAllPureFunctions() {
		List<String> functionDefinitions = new ArrayList<String>();
		return functionDefinitions;
	}
	
	public List<String> getAllViewFunctions() {
		List<String> functionDefinitions = new ArrayList<String>();
		return functionDefinitions;
	}
	
	public int hasFallbackFunction() {
		int fallbackFunctionCount = 0;
		return fallbackFunctionCount;
	}
	
	public int hasPayableFallbackFunction() {
		int payableFallbackFunctionCount =0;
		return payableFallbackFunctionCount;
	}
	
	public boolean isFallbackFunction(AST functionDefinition) {
		return true;
	}
	
	public boolean isPayableFallbackFunction(AST functionDefinition) {
		return true;
	}
}
