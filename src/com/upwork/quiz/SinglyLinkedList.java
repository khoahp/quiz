package com.upwork.quiz;

public class SinglyLinkedList<T> {
	private Node<T> lastNode;
	private int nodeCount;

	public SinglyLinkedList() {
		this.lastNode = null;
		this.nodeCount = 0;
	}

	public int size() {
		return nodeCount;
	}

	public boolean isEmpty() {
		return this.nodeCount == 0;
	}

	public void add(T data) {
		Node<T> currentNode = new Node<T>(data);

		if (this.lastNode != null) {
			currentNode.index = lastNode.index + 1;
			currentNode.previousNode = lastNode;
			lastNode.nextNode = currentNode;
		} else {
			currentNode.previousNode = null;
			currentNode.index = 0;
		}
		this.lastNode = currentNode;
		this.nodeCount++;
	}

	public T get(int index) {
		if (this.isEmpty() || index < 0 || index >= this.nodeCount) {
			return null;
		}
		//
		Node<T> currentNode;
		int count = lastNode.index - index;
		currentNode = lastNode;

		while (count > 0) {
			currentNode = currentNode.previousNode;
			count--;
		}

		return currentNode.data;
	}

	public Node<T> getNode(int index) {
		if (this.isEmpty() || index < 0 || index > this.nodeCount) {
			return null;
		}
		//
		int count = lastNode.index - index;
		Node<T> currentNode = lastNode;

		while (count > 0) {
			currentNode = currentNode.previousNode;
			count--;
		}

		return currentNode;
	}

	public boolean insert(T data, int index) {
		Node<T> currentNode;

		if (this.getNode(index) != null) {
			Node<T> newNode = new Node<T>(data);
			currentNode = this.getNode(index);
			newNode.index = index;

			if (currentNode.previousNode != null) {
				currentNode.previousNode.nextNode = newNode;
				newNode.previousNode = currentNode.previousNode;
				currentNode.previousNode = newNode;
				newNode.nextNode = currentNode;
			} else {
				currentNode.previousNode = newNode;
				newNode.nextNode = currentNode;
			}
			currentNode = newNode;

			while (currentNode.nextNode != null) {
				currentNode = currentNode.nextNode;
				currentNode.index++;
			}

			this.nodeCount++;
			return true;
		} else {
			return false; 
		}
	}

	public boolean remove(int index) {
		Node<T> currentNode;

		if (this.getNode(index) != null) {
			currentNode = this.getNode(index);

			if (currentNode.previousNode != null) {
				currentNode.nextNode.previousNode = currentNode.previousNode;
				currentNode.previousNode.nextNode = currentNode.nextNode;
			} else if (currentNode.nextNode != null) {
				currentNode.nextNode.previousNode = null;
			} else if (this.isEmpty()) {
				this.lastNode = null;
			}

			while (currentNode.nextNode != null) {
				currentNode = currentNode.nextNode;
				currentNode.index--;
			}

			this.nodeCount--;
			return true;
		} else {
			return false;
		}
	}

	public class Node<T> {
		public Node<T> nextNode = null;
		public Node<T> previousNode = null;
		public int index;
		public T data;

		public Node(T data) {
			this.data = data;
		}
	}
}
