package com.upwork.quiz;

public class QuizLinkedList<T> {
	private Node<Integer> root;
	private int countSize;

	public QuizLinkedList() {
		root = null;
		countSize = 0;
	}

	public boolean isEmpty() {
		return this.countSize == 0;
	}

	public int size() {
		return this.countSize;
	}

	public boolean append(Integer var) {
		Node<Integer> newNode = new Node<Integer>(var);
		if (null == this.root || countSize == 0) {
			this.root = newNode;
			countSize++;
			return true;
		}

		Node<Integer> currentNode = root;
		while (currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
		}
		currentNode.setNextNode(newNode);
		newNode.setPreviousNode(currentNode);
		countSize++;
		return true;
	}

	public Node<Integer> searchNodeByIndex(int index) {
		if (this.isEmpty() || index > countSize - 1) {
			return null;
		}
		int count = 0;
		Node<Integer> currentNode = root;
		while (currentNode.getNextNode() != null) {
			if (count == index) {
				break;
			}
			currentNode = currentNode.getNextNode();
			count++;
		}
		return currentNode;
	}

	public boolean removeTail() {
		if (null == this.root) {
			return false;
		}
		if (null != this.root || null == this.root.getNextNode()) {
			this.root = null;
			countSize--;
			return true;
		}
		Node<Integer> currentNode = root;
		while (currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
		}
		currentNode.getPreviousNode().nextNode = null;
		countSize--;
		return true;
	}

	public boolean removeLagerNode(Integer var) {
		if (this.isEmpty()) {
			return false;
		}
		
		int i = 0;
		
		while (this.countSize > i) {
			Node<Integer> currentNode = searchLagerByData(var);

			if (null == currentNode) {
				return false;
			}

			if (currentNode.getNextNode() != null && currentNode.getPreviousNode() != null) {
				currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
				currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
				countSize--;
			} else if (currentNode.getNextNode() != null && currentNode.getPreviousNode() == null) {
				currentNode.getNextNode().prevNode = null;
				countSize--;
			} else {
				currentNode.getPreviousNode().nextNode = null;
				countSize--;
			}
			
			i++;
		}
		

		return true;
	}

	public Node<Integer> searchLagerByData(Integer var) {
		if (this.isEmpty()) {
			return null;
		}
		
		Node<Integer> currentNode = root;
		while (currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
			if (var > currentNode.getData()) {
				return currentNode;
			}
		}
		return null;
	}

	class Node<Integer> {
		private Node<Integer> prevNode;
		private Node<Integer> nextNode;
		Integer data;

		public Node() {
		}

		public Node(Integer var) {
			this.data = var;
		}

		public boolean setData(Integer var) {
			this.data = var;
			return true;
		}

		public Integer getData() {
			return this.data;
		}

		private void setNextNode(Node<Integer> n) {
			if (null != this.nextNode) {
				this.nextNode.prevNode = n;
				n.nextNode = this.nextNode;
			}
			this.nextNode = n;
			n.prevNode = this;
		}

		private void setPreviousNode(Node<Integer> n) {
			if (null != this.prevNode) {
				n.prevNode = this.prevNode;
				this.prevNode.nextNode = n;
			}
			this.prevNode = n;
			n.nextNode = this;

		}

		private Node<Integer> getNextNode() {
			if (null != this.nextNode) {
				return this.nextNode;
			}
			return null;

		}

		private Node<Integer> getPreviousNode() {
			if (null != this.prevNode) {
				return this.prevNode;
			}
			return null;
		}

	}

}
