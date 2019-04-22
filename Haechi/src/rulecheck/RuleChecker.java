package rulecheck;

import java.util.List;
import util.Position;
import util.ValidationRule;

public class RuleChecker {
	String results = "********** DIAGNOSTIC RESULTS **********\r\n";

	public String ruleCheck() {
		RuleRepository ruleRepository = new RuleRepository();
		Position position = new Position();
		List<ValidationRule> rules = ruleRepository.getRules();

		for(ValidationRule rule : rules) {
			results += "========== " + rule.getRuleName() + " ==========\r\n";
			rule.analyze();
			List<String> characterCounts = rule.getCharacterCounts();
			
			if(characterCounts.isEmpty()) {
				results += "None\r\n";
			}
			else {
				for(String characterCount : characterCounts) {
					results += "[" + rule.getRuleCriticality() + "] " + rule.getRuleName() + " warning '" + 
						rule.getComment() + "' Line : " + position.getLineNumber(characterCount) + "\r\n";
	                // System.out.printf("[%s] %s warning ('%s') Line:%s%n",
	                //         rule.getRuleCriticality(),
	                //         rule.getRuleName(),
	                //         rule.getComment(),
	                // 		position.getLineNumber(characterCount));
				}
			}
			// System.out.println();
		}
		
		return results;
	}
}

