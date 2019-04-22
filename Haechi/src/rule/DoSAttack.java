package rule;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import context.FunctionCallContext;
import node.AST;
import node.FunctionCall;
import util.ValidationRule;

public class DoSAttack implements ValidationRule{
	List<String> characterCounts = new ArrayList<String>();
	
	@Override
	public void analyze() {
		characterCounts.clear();
		
		FunctionCallContext functionCallContext = new FunctionCallContext();
    	List<FunctionCall> functionCalls = functionCallContext.getAllFunctionCalls();
    	
    	for(FunctionCall functionCall : functionCalls) {
    		// Check whether require function is used.
    		if(functionCall.getMemberName().equals("None") &&
    				functionCall.getName().equals("require")) {	
    			characterCounts.add(functionCall.getCharacterCount());
    		}
    		
    		// Check whether transfer function is used in loop statement .
    		else {
    			AST parent = null;
    			String parentName = null;
    			try {
            		parent = functionCall.getParent();
            		parentName = parent.getClass().getSimpleName();
            		
    				while(!(parentName.equals("WhileStatement") || 
    						parentName.equals("ForStatement") ||
    						parentName.equals("DoWhileStatement"))) {
    					parent = parent.getParent();
    					parentName = parent.getClass().getSimpleName(); // Exception point.
    				}
    				
					JSONObject expression = functionCall.getExpression();
					if(expression.get("memberName").equals("transfer")) {
						expression = (JSONObject) expression.get("expression");
						expression = (JSONObject) expression.get("expression");
						if(expression.get("name").equals("msg") || expression.get("name").equals("tx")){
							String count = (String) expression.get("src");
							count = count.split(":")[0];
							characterCounts.add(count);
						}
					}
					
    			} catch(NullPointerException e) {
//        			e.printStackTrace();
    			}
    		}
    	}
    	
	}

	@Override
	public Criticity getRuleCriticality() {
	    return Criticity.MAJOR;
	}

	@Override
	public String getRuleName() {
	    return "DoSPatterns";
	}

	@Override
	public String getComment() {
	    return "Potential vulnerability to DoS attack";
	}
    
	@Override
	public List<String> getCharacterCounts() {
		return characterCounts;
	}
}
