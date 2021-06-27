import java.util.Random;
public class prg3b {
	static int randomInteger;
	public static void main(String[] args)
	{
		System.out.println("For 10 Random numbers");
		MyThread1 thread1 = new MyThread1();
		Thread thread = new Thread(thread1);
		thread.start();
	}
}
class MyThread1 implements Runnable
{
	public void run()
	{
		int i = 0;
		try 
		{
			while(i<10)
			{
				Random random = new Random();
				prg3b.randomInteger = random.nextInt(10);
				System.out.println((i+1)+" Random integer is "+prg3b.randomInteger);
				MyThread2 thread2 = new MyThread2();
				MyThread3 thread3 = new MyThread3();
				Thread t1 = new Thread(thread2);
				Thread t2 = new Thread(thread3);
				t1.start();
				t2.start();
				Thread.sleep(1*1);
				System.out.println("\n");
				i++;
			}
		}
		catch (InterruptedException exception)
		{
			exception.printStackTrace();
		}
	}
}
class MyThread2 implements Runnable 
{
	public void run()
	{
		System.out.println("Square of" + prg3b.randomInteger + " is "+prg3b.randomInteger*prg3b.randomInteger);
	}
}
class MyThread3 implements Runnable
{
	public void run()
	{
		System.out.println("Cube of" + prg3b.randomInteger + " is "+prg3b.randomInteger*prg3b.randomInteger*prg3b.randomInteger);
	}
}
