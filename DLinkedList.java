package lab3;


public class DLinkedList<T> {
	private Node firstNode;
	private Node lastNode;
	private Node middleNode;
	private int numberOfEntries;
	private int middlePosition;

	public DLinkedList() {
		firstNode = null;
		lastNode = null;
		middleNode = null;
		numberOfEntries = 0;
		middlePosition = 0;
	}

	public void add(T newEntry) {
		if (firstNode == null) {
			firstNode = new Node(null, newEntry, null);
			lastNode = firstNode;
		} else {
			Node newNode = new Node(lastNode, newEntry, null);
			lastNode.next = newNode;
			lastNode = newNode;
		}

		numberOfEntries++;

		if (numberOfEntries % 2 == 1) {
			if (middleNode == null) {
				middleNode = firstNode;
			} else {
				middleNode = middleNode.next;
			}
			middlePosition++;
		}
	}

	public T getEntry(int givenPosition) {
		T result = null;

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			result = (getNodeAt(givenPosition)).data;
		}

		return result;
	}

	private Node getNodeAt(int givenPosition) {
		Node currentNode = firstNode;

		for (int counter = 1; counter < givenPosition; counter++) {
			currentNode = currentNode.next;
		}

		return currentNode;
	}

	public T getEntry1(int givenPosition) {
		T result = null;

		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			result = (getNodeAt1(givenPosition)).data;
		}

		return result;
	}

	/**
	 * Modify this method according to the Solution 1
	 */
	private Node getNodeAt1(int givenPosition) {
		if (numberOfEntries % 2 == 1) {
		
		}
		if (givenPosition > (numberOfEntries / 2)) {
			Node currentNode = lastNode;
			for (int counter = numberOfEntries; counter > givenPosition; counter--) {
				currentNode = currentNode.previous;
			}
			return currentNode;
		} else {
			return getNodeAt(givenPosition);
		}
	}

	public T getEntry2(int givenPosition) {
		T result = null;
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
			result = (getNodeAt2(givenPosition)).data;
		}
		return result;
	}

	/**
	 * Modify this method according to the Solution 2
	 */
	private Node getNodeAt2(int givenPosition) {
		if (givenPosition < middlePosition) {
			Node currentNode = middleNode;
			for (int counter = (middlePosition); counter > givenPosition; counter--) {
				currentNode = currentNode.previous;
			}
			return currentNode;
		} else if (givenPosition > middlePosition) {

			Node currentNode = middleNode;
			for (int counter = (middlePosition); counter < givenPosition; counter++) {
				currentNode = currentNode.next;
			}
			return currentNode;

		} else {
			return getNodeAt1(givenPosition);
		}
	}

	private class Node {
		private Node previous;
		private T data;
		private Node next;

		private Node(Node previousNode, T aData, Node nextNode) {
			previous = previousNode;
			data = aData;
			next = nextNode;
		}

		public String toString() {
			return data.toString();
		}
	}
}