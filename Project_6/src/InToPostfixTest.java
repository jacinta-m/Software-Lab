
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;

public class InToPostfixTest {
	
	public static void main(String[] args) throws ScriptException{

		boolean check = true;
		JOptionPane.showMessageDialog(null, "Welcome to the Program that converts expressions from infix to postfix");	
		boolean programquit = true;
		
		while(programquit) {
			InfixToPostfix test = new InfixToPostfix();
			StringBuffer infix = new StringBuffer();
			
		do {
			infix.append(JOptionPane.showInputDialog("Please enter an equation:"));
			check = true;
			//Check if input is valid for at least more than 1 value
			if(infix.length()<=1) {
				System.out.println("Please enter a valid expression with more than one component");
				JOptionPane.showMessageDialog(null,"Please enter a valid expression with more than one component", "Error",JOptionPane.ERROR_MESSAGE);
				infix.delete(0, infix.length());
				check = false;
			}
			//Check if the equation has at least 1 operator else it just a number or character
			int operatorCount = test.infixCheck(infix);
			if(operatorCount ==0) {
				System.out.println("Please enter a valid expression with at least one operator");
				JOptionPane.showMessageDialog(null,"Please enter a valid expression with at least one operator", "Error",JOptionPane.ERROR_MESSAGE);
				infix.delete(0, infix.length());
				check = false;
			}
			//Checking the equation has the right number of parenthesis
			if(!test.ParentsCheck(infix)) {
				System.out.println("Please enter a valid expression with correct parenthesis");
				JOptionPane.showMessageDialog(null,"Please enter a valid expression with correct parenthesis", "Error",JOptionPane.ERROR_MESSAGE);
				infix.delete(0, infix.length());
				check = false;
			}
		}while(!check);
		StringBuffer t1 = test.convertToPostfix(infix);
		String infix_msg = String.format( "Your infix expression is: %s%n", infix.toString());
		String postfix_msg = String.format("Your postfix expression is: %s", t1.toString());
		JOptionPane.showMessageDialog(null, infix_msg + postfix_msg);
		
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to evaluate the expression? It is only possible with numerical values", "Evaluate Expression", dialogButton);
		if(dialogResult == 0) {		
			try {
				ScriptEngineManager mgr = new ScriptEngineManager();
				ScriptEngine engine = mgr.getEngineByName("JavaScript");
				String infix2 = infix.toString();
				int count=0;
				for(int i=0; i<infix2.length();++i) {
					if(Character.isDigit(infix2.charAt(i))) {
								++count;
					}
				}
				if(count!=0) {
					String result = engine.eval(infix2).toString();
					String Exp_msg = String.format( " %s = ", infix2);
					String Result_msg = String.format(result);
					JOptionPane.showMessageDialog(null,  Exp_msg + Result_msg );
			
				}
				else {
					throw new IllegalArgumentException();
				}
			}catch(IllegalArgumentException exception) {
				System.out.print("Cannot calculate value for an equation with no numbers");
				JOptionPane.showMessageDialog(null,"Cannot calculate value for an equation with no numbers", "Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		int diaButton = JOptionPane.YES_NO_OPTION;
		int diaResult = JOptionPane.showConfirmDialog(null, "Would you like to evaluate another expression?", "Evaluate Expression", dialogButton);
		
		if(diaResult == 1) {
			programquit = false;
		}
		}
	}
}
