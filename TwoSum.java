import java.util.*;
public class TwoSum
{
	public void swap(int [] num, int i, int j)	//swaps two integers with one another
	{
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	public int findSmallest(int [] num, int start)	//finds the smallest integer in the array
	{
		int smallest = start;
		for (int i = start + 1; i < num.length; i++)
		{
			if (num[i] < num[smallest])
			{
				smallest = i;
			}
		}
		return smallest;
	}
	public int [] sort(int [] num)	//swaps the smallest with the first index it can be placed in
	{
		for (int i = 0; i < num.length - 0; i++)
		{
			swap(num, i, findSmallest(num, i));
		}
		return num;
	}
	public int [] twoSums(int [] num, int sum)
	{
		int beginning = 0;	
		int end = num.length - 1;
		sort(num);
		while(beginning < end)	// beginning and end have not crossed 
		{
			if (num[beginning] + num[end] == sum && num[beginning] != num[end])	//if the two values added together equal the target value(sum)
			{
				System.out.println("Sorted Array: " + Arrays.toString(num));
				return new int[] {beginning, end};	//returns the answer
			}
			else if (num[beginning] + num[end] < sum)	// if the values are less than the target value try another value right of the beginning value
			{
				beginning++;
			}
			else if (num[beginning] + num[end] > sum)
			{
				end--;	// if the values are greater than the target value try another value left of the end value
			}
			else 
			{
				return new int[] {-1,-1};	//if there are duplicates return [-1, -1]
			}
		}
		return new int[] {-1,-1};	//if there is no solution return [-1, -1]
	}			


	public static void main(String[] args)
	{
		TwoSum sums = new TwoSum();
		int[] num1 = new int[] {2, 12, 8, 7};
		int[] num2 = new int[] {1, 13, 18, 20, 20, 30};

		System.out.println(Arrays.toString(sums.twoSums(num1, 9)));
		System.out.println(Arrays.toString(sums.twoSums(num2, 40)));
		
	}
}