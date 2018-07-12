import java.util.Stack;

public class InfixToPostfix {
	private Stack<Character> operators = new Stack<>(); // create a Stack

	public InfixToPostfix() {
		this.operators = operators;
	}
	
	public StringBuffer convertToPostfix(StringBuffer infix) {
		StringBuffer postfix = new StringBuffer();
		
		for(int i=0; i< infix.length(); ++i) {
			char item = infix.charAt(i);
			
			//If the item is not an operator or parenthesis then add to postfix
			if(!isOperator(item)) {
				postfix.append(item);
				}
			//If the item is a left parenthesis then push to the operators Stack
			else if (item == '(') {
	                operators.push(item);
			}
			//If the item is a right a right parenthesis then pop from the Stack until a left parenthesis is on top 
			else if (item == ')') {
				while (operators.peek() != '(') {
					postfix.append(operators.pop());
				}
				if (!operators.isEmpty() && operators.peek() != '(') {
					return (postfix.append("Invalid Expression")); // invalid expression      
				}
				else {
					operators.pop();
				}
			}	
			//The case for the operators, push to the operators Stack 
			else {
				while(!operators.isEmpty() && precedence(item)<=precedence(operators.peek())) {
					postfix.append(operators.pop());
				}
				operators.push(item);
			}
		}
		
		while (!operators.isEmpty()) {
			postfix.append(operators.pop());
		}
		return postfix;
	}
	//determining whether the character is an operator
	public boolean isOperator(char c) {
		return precedence (c) >0;
	}
	//method to determine the precedence of the operators
	public int precedence(char c) {
		if (c == '(' || c == ')') {
			return 1;
		}
		else if (c== '+' || c == '-') {
			return 2;
		}
		else if(c == '*'||c == '/' || c == '%' ) {
			return 3;
		}
		else if (c == '^') {
			return 4;
		}
		else {
			return 0;
		}
	}
	
	public char Peek() {
		return operators.peek();
	}
	
	//method to count how many operators are in the infix string
	public int infixCheck(StringBuffer infix) {
		int count =0;
		for(int i=0; i< infix.length(); ++i) {
			if (isOperator(infix.charAt(i))) {
				++count;
			}
		}
		return count;
	}
	//method to check for correct parenthesis 
	public boolean ParentsCheck(StringBuffer infix) {
		int leftCount=0;
		int rightCount=0;
		for(int i=0; i< infix.length(); ++i) {
			if (infix.charAt(i)==')') {
				++rightCount;
			}
			if (infix.charAt(i)=='(') {
				++leftCount;
			}
		}
		return (leftCount==rightCount);
	}
}

