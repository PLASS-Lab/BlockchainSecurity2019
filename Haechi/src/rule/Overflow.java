package rule;

import java.util.ArrayList;
import java.util.List;

import util.ValidationRule;

public class Overflow implements ValidationRule{
	List<String> characterCounts = new ArrayList<String>();
	
	@Override
	public void analyze() {
		characterCounts.clear();
		/*
		...
		check the weakness
		...
		*/
	}

	@Override
	public Criticity getRuleCriticality() {
	    return Criticity.MAJOR;
	}

	@Override
	public String getRuleName() {
	    return "Overflow";
	}

	@Override
	public String getComment() {
	    return "Note the operation of integer variables";
	}
    
	@Override
	public List<String> getCharacterCounts() {
		return characterCounts;
	}
}
