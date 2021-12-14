package Placement;

import java.util.Scanner;

public class PizzaForces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int _t=0;_t<t;_t++)
		{
			
			long n=scanner.nextLong();
			
			long number6 =6L;
			long rem=n%6;
			if(n<6)
			{
			System.out.println(15);
			continue;
			}
			long val=n/number6;
			if(rem==0)
			{
				System.out.println(val*15);
			}
			else if (rem<3)
			{
				System.out.println((val-1)*15+20);
			}
			else if (rem<5)
			{
				System.out.println((val-1)*15+25);
			}
			else
			{
				//long val=n/number6;
				System.out.println((val+1)*15);
			}

		}
	}

}
