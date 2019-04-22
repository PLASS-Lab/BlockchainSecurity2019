package main;

import org.json.simple.JSONObject;
import util.Position;
import util.Printer;
import rulecheck.RuleChecker;
import node.ParsingToAST;

public class Main {
	public static void main(String[] args) {
		String inputFile = "";
		String json = "";
		try {
			inputFile = args[0];
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		Scanner scanner = new Scanner();
		json = scanner.createJson(inputFile);
		
		ParsingToAST parsingToAST = new ParsingToAST();
		JSONObject jsonObject = parsingToAST.parse(json);
		parsingToAST.visitNode(jsonObject);
		
		Position.setup(inputFile);
		
		Printer printer = new Printer();
		printer.init();
		printer.generate(inputFile);
		
		RuleChecker ruleChecker = new RuleChecker();
		String results = ruleChecker.ruleCheck();
		System.out.println(results);
	}
}