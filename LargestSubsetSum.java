import java.util.Arrays;
import java.util.Scanner;

public class LargestSubsetSum {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of input Array");
		int size = sc.nextInt();
		System.out.println("Enter Elements of array");
		
		int[] array = new int[size];
		for (int i =0 ; i< size ;i++) {
			array[i] = sc.nextInt();
		}
		System.out.println("Largest Subset Sum: "+Arrays.toString(getSubsetSum(array)));
	}
	
	public static int[] getSubsetSum(int[] array) {
		int[] ret = new int[array.length];
		for(int i=0;i<array.length;i++) {
			int val = getSubsetSumWithLCM(array[i]);
			ret[i] = val;
		}
		return ret;
	}

	public static int getSubsetSumWithLCM(int num) {
		int max_sum = 0; 
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				max_sum += i;
				if (num / i != i)
					max_sum += (num / i);
			}
		}
		return max_sum;
	}
	
}
