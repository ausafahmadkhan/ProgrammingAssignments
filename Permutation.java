import java.util.Scanner;
public class Permutation
{
	public static void main(String args[])
	{
		RandomizedQueue<String> rq = new RandomizedQueue();
		int k = Integer.parseInt(args[0]);
		Scanner sc = new Scanner(System.in);
		String st = "";
		while(sc.hasNextLine() && !(st = sc.nextLine()).equals(""))
		{
			rq.enqueue(st);
		}
		for (int i = 0; i < k; i++)
		{
			System.out.println(rq.dequeue());
		}
	}
}