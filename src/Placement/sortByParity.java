package Placement;

import java.util.Arrays;

public class sortByParity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {0,1,2,3};
		System.out.println(arr.toString());
		sortByParity(arr);
	}

	private static void sortByParity(int[] arr) {
		// TODO Auto-generated method stub
		int x=1;
		int i=0,j=arr.length-1;
		while(i<j)
		{
			if((arr[i]&x)==0)
			{
				i++;
				while(i<j)
				{
					if((arr[i]&x)==0)
					{
						i++;
					}
					else
						break;

				}
				//System.out.println(Arrays.toString(arr));
			}
			
			if((arr[j]&x)==1)
			{
				
				//j--;

				while(j>i)
				{
					if((arr[j]&x)==1)
					{
						j--;
					}
					else
						break;

				}
				//System.out.println(Arrays.toString(arr));
			}

			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
			System.out.println(Arrays.toString(arr));

		}
		System.out.println(Arrays.toString(arr));

	}

}
