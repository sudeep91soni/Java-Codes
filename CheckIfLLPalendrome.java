package geeksForGeeks.linkedList;

import java.util.LinkedList;
import java.util.List;

public class CheckIfLLPalendrome {

	public static void main(String[] args) {
		CheckIfLLPalendrome obj = new CheckIfLLPalendrome();

		List<String> list = new LinkedList<String>();
		obj.fillList(list);

		obj.checkPalendrome(list);
	}

	public void fillList(List<String> list) {
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("b");
		list.add("a");
	}

	public void checkPalendrome(List<String> list) {
		int i = 0;

		while (list.get(i) == list.get(list.size() - i - 1)
				&& i < list.size() / 2) {
			i++;
		}
		if (i < list.size() / 2) {
			System.out.println("Not a palendrome");
		} else {
			System.out.println("Is a palendrome");
		}
	}

}
