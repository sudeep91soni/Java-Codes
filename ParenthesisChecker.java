package geeksForGeeks.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParenthesisChecker {

	public static void main(String[] args) {
		String sample = "[()]{}{[()()]()}";
		ParenthesisChecker checker = new ParenthesisChecker();
		System.out.println(checker.checkCorrect(sample));
	}

	private boolean checkCorrect(String sample) {
		if (sample == null) {
			return false;
		}
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(']', '[');
		map.put(')', '(');
		map.put('}', '{');

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < sample.length(); i++) {
			if (map.containsKey(sample.charAt(i))) {
				if (stack.size() == 0
						|| stack.peek() != map.get(sample.charAt(i))) {
					return false;
				} else {
					stack.pop();
				}
			} else if (map.containsValue(sample.charAt(i))) {
				stack.push(sample.charAt(i));
			}
		}
		if (stack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
