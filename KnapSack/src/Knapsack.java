import java.util.Scanner;
public class Knapsack
{
	double weight[];
	double benefit[];
	double ratio[];
	double W;
	Knapsack()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the numbers of objects: ");
		int nItems = scan.nextInt();
		weight = new double[nItems];
		benefit = new double[nItems];
		ratio = new double[nItems];
		System.out.println("Enter the object's weights");
		for(int i = 0;i < nItems;i++)
			weight[i] = scan.nextDouble();
		System.out.println("Enter the object's profits");
		for(int i = 0;i < nItems;++i)
			benefit[i] = scan.nextDouble();
		for(int i =0;i<nItems;++i)
			ratio[i] = benefit[i]/weight[i];
		System.out.println("Enter the capacity of the knapsack: ");
		W = scan.nextDouble();
	}
	int getNext()
	{
		double highest = 0;
		int index = -1;
		for(int i = 0; i<benefit.length;++i)
		{
			if(ratio[i]>highest)
			{
				highest = ratio[i];
				index = i;
			}
		}
		return index;
	}
	void full()
	{
		double cW = 0;
		double cB = 0;
		System.out.println("\n Objects considered: ");
		while (cW<W)
		{
			int item = getNext();
			if(item == -1)
			{
				break;
			}
			System.out.println((item + 1) + "");
			if (cW + weight[item]<=W)
			{
				cW += weight[item];
				cB += benefit[item];
				ratio[item] = 0;
			}
			else
			{
				cB += (ratio[item] * (W - cW));
				cW += (W-cW);
				break;
			}
		}
		System.out.println("\n The Optimal Solution i.e. Max Benefit = "+cB);
	}
	public static void main(String[] args)
	{
		Knapsack fk = new Knapsack();
		fk.full();
	}
}