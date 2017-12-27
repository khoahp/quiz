package com.upwork.quiz;

public class MainRun {
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.add(1);
		System.out.printf("%d %d%n", list.get(0), list.get(1));
	}
}
