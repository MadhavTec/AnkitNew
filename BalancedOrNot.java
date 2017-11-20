import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BalancedOrNot {
	private static String[] expressions = null;
	private static int[] maxReplacements = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of Expression Array");
		int size = sc.nextInt();
		System.out.println("Enter Expression");
		
		expressions = new String[size];
		for (int i =0 ; i< size ;i++) {
			expressions[i] = sc.next();
		}
		
		System.out.println("Enter the size of Max Replacement Array");
		int size1 = sc.nextInt(); 
		
		System.out.println("Enter Max Replacement Array elemnts");
		maxReplacements = new int[size1];
		for (int i =0 ; i< size1 ;i++) {
			maxReplacements[i] = sc.nextInt();
		}
		
		System.out.println("output:"+Arrays.toString(balancedOrNot(expressions, maxReplacements)));
	}
	
	public static Integer[] balancedOrNot(String[] expressions, int[] maxReplacements) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < expressions.length; i++) {
			stack.push(balancedOrNot(expressions[i], maxReplacements[i]));
		}
		return stack.toArray(new Integer[0]);
	}

	public static int balancedOrNot(String expression, int maxReplacement) {
		char[] chrs = expression.toCharArray();
		List<Character> myList = new ArrayList<Character>();
		for (char ch : chrs) {
			myList.add(ch);
		}
		for (int i = 0; i < myList.size() - 2; i++) {
			if (myList.get(i) == '<' && myList.get(i + 1) == '>') {
				myList.remove(i);
				myList.remove(i + 1);
			}
		}
		return (getCount(myList, '>') == maxReplacement) ? 1 : 0;
	}

	public static boolean isOpenTerm(char ch) {
		return (ch == '<') ? true : false;
	}

	public static int getCount(List<Character> myList, char ch) {
		int count = 0;
		for (char c : myList) {
			if (c == ch)
				count++;
		}
		return count;
	}


}
