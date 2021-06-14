import java.util.*;

public class Armstrong {
	public static void main (String [] args)
	{	
		System.out.println("Enter number: ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int original,remainder,result = 0;
		original = number;
		while(original != 0)
		{
			remainder = original % 10;
			result += Math.pow(remainder, 3);
			original /= 10;
		}
		if(result == number)
			System.out.println(number + " is Armstrong");
		else
			System.out.println(number + " is not Armstrong");
	}
}
