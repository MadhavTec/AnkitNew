import java.util.Arrays;
import java.util.Scanner;

public class BuyingShowTickets {
	private static int [] tempArrray = null; 
	private static int position =0 ;

	public static void main(String[] args) {
		System.out.println("First Test Case");
		ticketHelpeer();
		long output = waitingTime(tempArrray, position);
		System.out.println("waiting time: " + output);	
		
		System.out.println("Second Test Case");
		ticketHelpeer();
		long output1 = waitingTime(tempArrray, position);
		System.out.println("waiting time: " + output1);
		System.out.println("");
	}
	
	public static void ticketHelpeer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of ticket Array");
		int size = sc.nextInt();
		
		tempArrray = new int[size];
		System.out.println("Enter Array Elements");
		
		for (int i =0 ; i< size ;i++) {
			tempArrray[i] = sc.nextInt();
		}
		System.out.println("Enter Jesseys position");
		position = sc.nextInt();
		
	}

	public static long waitingTime(int[] tickets, int p) {
		long waitingTimes = 0;
		int[] tempArray = Arrays.copyOf(tickets, tickets.length);
		for (int i = 0; i < tickets.length; i++) {
			tempArray[i] = tickets[i] - tickets[p];
		}
		for (int i = 0; i < tickets.length; i++) {
			if (tempArray[i] < 0)
				waitingTimes += tickets[i];
			else {
				if (i <= p)
					waitingTimes += tickets[p];
				else
					waitingTimes += tickets[p] - 1;
			}
		}
		return waitingTimes;
	}

}

