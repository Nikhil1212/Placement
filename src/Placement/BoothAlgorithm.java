package Placement;

import java.util.Arrays;
import java.util.Scanner;

public class BoothAlgorithm {

	public static void main(String args[]){
		String str; 
		while(true)
		{
			Scanner scanner=new Scanner(System.in);
			str=scanner.next();
			System.out.println(BoothAlgo(str));
		}

	}
	public static int BoothAlgo(String string){
		int len = string.length();
		char str[]=new char[len*2];
		for(int i=0;i<len;i++)
		{
			str[i]=string.charAt(i);
		}
		for(int i=len;i<(len*2);i++)
		{
			str[i]=string.charAt(i-len);
		}
		int k, i, j;
		k = 0;
		int failureArr[]=new int[2*len];
		for( i = 0; i < 2*len; ++i)
			failureArr[i] = -1; //-1 indicates that the failure function does not point backward in the string.
		for ( j = 1; j < 2*len; ++j) {
			i = failureArr[j-k-1];
			while( i != -1 && str[j] != str[k+i+1]){ // k is the starting point and +1 because we have initialized the array with -1.
				if( str[j] < str[k+i+1] )
					k = j-i-1;
				i = failureArr[i];
			}
			if( i == -1 && str[j] != str[k+i+1] ){ //I think we are reaching here something similar as KMP where just we are 
				if( str[j] < str[k+i+1] )
					k = j; //we got the  index of the smallest character scanned so far scanned from 0 to j.
				failureArr[j-k] = -1;
			}
			else
				failureArr[j-k] = i+1;

			System.out.println(Arrays.toString(failureArr));

		}
		return k;
	}





}
