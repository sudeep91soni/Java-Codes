package geeksForGeeks.stack;

import java.util.Stack;

public class ReverseAStack {

	public static void main(String[] args) {

		ReverseAStack rev = new ReverseAStack();
		Stack<String> stack = new Stack<String>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		StackUtil.traverseStack(stack);
		StackUtil.traverseStack(rev.reverseStack(stack));
	}

	private Stack<String> reverseStack(Stack<String> stack) {
		if (stack.size() != 0) {
			String popped = stack.pop();
			reverseStack(stack);
			putInBottom(stack, popped);
		}
		return stack;
	}

	private void putInBottom(Stack<String> stack, String popped) {

		if (stack.size() == 0) {
			stack.push(popped);
			return;
		}
		String element = stack.pop();
		putInBottom(stack, popped);
		stack.push(element);
	}
}
