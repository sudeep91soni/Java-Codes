package geeksForGeeks.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesOfSameLevel {

	static void connect(TreeNodeNext node) {
		if (node == null) {
			return;
		} else {
			for (int i = 0; i < TreesUtils.getHeight(node); i++) {
				Queue<TreeNodeNext> queue = new LinkedList<TreeNodeNext>();
				exploreLevel(node, i, queue);
				TreeNodeNext qNode = queue.poll();
				TreeNodeNext tmp = qNode;
				while (!queue.isEmpty()) {
					tmp.next = queue.poll();
					tmp = tmp.next;
				}
				traverseThroughLevel(qNode);
				System.out.println();
			}
		}
	}

	private static void traverseThroughLevel(TreeNodeNext qNode) {
		if (qNode == null) {
			return;
		}
		System.out.print(qNode.value + " ");
		traverseThroughLevel(qNode.next);
	}

	private static void exploreLevel(TreeNodeNext node, int i,
			Queue<TreeNodeNext> queue) {
		if (node == null) {
			return;
		}
		if (i == 0) {
			queue.add(node);
			return;
		} else if (i > 0) {
			exploreLevel((TreeNodeNext) node.left, i - 1, queue);
			exploreLevel((TreeNodeNext) node.right, i - 1, queue);
		}

	}
}
