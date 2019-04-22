package rule;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import context.ContractContext;
import node.ContractDefinition;
import util.ValidationRule;

public class MultipleInheritance implements ValidationRule{
	List<String> characterCounts = new ArrayList<String>();
	
	@Override
	public void analyze() {
		characterCounts.clear();
		
		ContractContext contractContext = new ContractContext();
		List<ContractDefinition> Contracts = contractContext.getAllContract();
		
		JSONArray baseContract;
		/*
		...
		check the weakness
		*/
	}

	@Override
	public Criticity getRuleCriticality() {
	    return Criticity.MAJOR;
	}

	@Override
	public String getRuleName() {
	    return "Multiple-Inheritance";
	}

	@Override
	public String getComment() {
	    return "Do not write multiple inheritance";
	}
    
	@Override
	public List<String> getCharacterCounts() {
		return characterCounts;
	}
}
