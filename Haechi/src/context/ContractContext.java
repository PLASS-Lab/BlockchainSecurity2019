package context;

import java.util.List;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import node.ContractDefinition;
import util.Position;

public class ContractContext{
	public List<ContractDefinition> getAllContract() {
		return ContractDefinition.getRegistry();
	}
	
	@SuppressWarnings("unchecked")
	public JSONArray getAllContractINFO() {

		Position position = new Position();
		ContractContext contractContext = new ContractContext();
		List<ContractDefinition> allContractDefinition = contractContext.getAllContract();
		
		JSONArray contractArray;
		JSONObject contractINFO = new JSONObject();
		
		contractArray = new JSONArray();
		for(ContractDefinition contractDefinition : allContractDefinition) {
			contractINFO = new JSONObject();
			contractINFO.put("id", contractDefinition.getId());
			contractINFO.put("name", contractDefinition.getName());
			contractINFO.put("kind", contractDefinition.getContractKind());
			contractINFO.put("line", position.getLineNumber(contractDefinition.getCharacterCount()));
			contractArray.add(contractINFO);
		}
		
		return contractArray;
	}
	
	public List<String> getAllContractNames() {
		List<String> contractNames = new ArrayList<String>();
		
		for(ContractDefinition contract : ContractDefinition.getRegistry()) {
			contractNames.add(contract.getName());
		}
		return contractNames;
	}
}


