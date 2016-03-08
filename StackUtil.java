package geeksForGeeks.stack;

import java.util.Stack;

public class StackUtil {

	public static void traverseStack(Stack<String> stack) {

		if(stack.size() == 0)
		{
			return;
		}
		String popped = stack.pop();
		System.out.println("Element of Stack: " + popped);
		traverseStack(stack);
		stack.push(popped);
	}

	
}
