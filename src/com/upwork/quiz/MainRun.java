package com.upwork.quiz;

public class MainRun {
	public static void main(String[] args) {

		QuizLinkedList<Integer> ls = new QuizLinkedList<>();
		
		ls.append(1);
		ls.append(1);
		ls.append(2);
		
		//ls.removeTail();

		ls.removeLagerNode(1);
		
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(ls.size()+ ""+ls.searchNodeByIndex(i).getData());
		}
		
	}
}
