import java.util.Arrays;
import java.util.Scanner;

public class PsychometricTesting {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of Score Array");
		int size = sc.nextInt();
		System.out.println("Enter Elements of Score array");
		
		int[] score = new int[size];
		for (int i =0 ; i< size ;i++) {
			score[i] = sc.nextInt();
		}
		
		System.out.println("Enter the size of LowerLimit Array");
		int size1 = sc.nextInt();
		System.out.println("Enter Elements of LowerLimit array");
		
		int[] lowerlimit = new int[size1];
		for (int i =0 ; i< size1 ;i++) {
			lowerlimit[i] = sc.nextInt();
		}
		
		System.out.println("Enter the size of upperLimit Array");
		int size2 = sc.nextInt();
		System.out.println("Enter Elements of upperLimit array");
		
		int[] upperlimit = new int[size2];
		for (int i =0 ; i< size2 ;i++) {
			upperlimit[i] = sc.nextInt();
		}
		System.out.println("output:"+Arrays.toString(jobOfffers(score, lowerlimit, upperlimit)));
	}
	
	
	public static int job(int[] score, int lowerLimit, int upperLimit) {
		int count = 0;
		int max = upperLimit;
		int min = lowerLimit;
		for (int i = 0; i < score.length; i++) {
			if (score[i] <= max) {
				if (score[i] >= min) {
					count++;
				}
			}
		}
		return count;
	}

	static int[] jobOfffers(int[] score, int[] lowerlimit, int[] upperlimit) {
		int len = lowerlimit.length;		
		int[] resultArray = new int[len];
		
		for (int i = 0; i < len; i++) {			
			resultArray[i] = job(score, lowerlimit[i], upperlimit[i]);
		}
		return resultArray;
	}

	

}
