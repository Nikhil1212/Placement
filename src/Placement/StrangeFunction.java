package Placement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class StrangeFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int _t=0;_t<t;_t++)
		{
			long n=scanner.nextLong();
			//n=10;
			long ans=0;
			long prev1=1;
			long prev2=2;
			if(n==1)
			{
				System.out.println(2);
				continue;
			}
			long val=(long) (Math.pow(10, 9)+7);
			int i=2;
				while(true)
			{
				prev1=lcm(1,i-1);
				prev2=lcm(1, i);
				long ctr=(n/prev1)-(n/prev2);
				if(ctr==0)
					break;
				long temp=(ctr*i)%val;
				ans=(ans+ctr*i)%val;
				i++;
			}
			System.out.println(ans);
		}
	}

	private static long lcm(long l, long r) {
		// TODO Auto-generated method stub
		HashMap<Long,Long> hashMap=new HashMap<Long,Long>();
		for(long i=l;i<=r;i++)
		{
			//i is the number
			for(long j=2;j<=i;j++)
			{
				//for computing the prime factors
				if(isPrime(j))
				{
					//check whether the divisor is prime or not.
					long numOfPrimeFactors=primeFactors(i,j);
					if(numOfPrimeFactors==0)
						continue;
					if(hashMap.containsKey(j))
					{
						long count=hashMap.get(j);
						if(count<numOfPrimeFactors)
						{
							hashMap.put(j,numOfPrimeFactors);
						}
					}
					else
						hashMap.put(j, numOfPrimeFactors);
				}
				else
					continue;
			}
		}
		//traversing the HashMap
		 Iterator hmIterator = hashMap.entrySet().iterator();
		 long ans=1;
		while(hmIterator.hasNext())
		{
			Map.Entry mapElement = (Map.Entry)hmIterator.next();
            long key = (long)mapElement.getKey() ;
            
            long val=(long)mapElement.getValue();
            ans*=key*val;
		}
		return ans;
	/*	long product=l*r;
		long small, large;
		if(l<r)
		{
			small=l;
			large=r;
		}
		else
		{
			small=r;
			large=l;
		}
		long hcf=computeHCF(small,large);
		
		return product/hcf;*/
	}

	private static long primeFactors(long num, long primefactor) {
		// TODO Auto-generated method stub
		long count=0;
		while((num%primefactor)==0)
		{
			count++;
			num=num/primefactor;
		}
		return count;
	}

	private static boolean isPrime(long j) {
		int i=2;
		while(i<(j/2))
		{
			if((j%i)==0)
				return false;
			i++;
		}
		return true;
	}

	private static long computeHCF(long small, long large) {
		
		while((large%small)!=0)
		{
			long div=large%small;
			large=small;
			small=div;
		}
		return small;
	}

}
