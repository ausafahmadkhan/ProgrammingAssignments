import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class QueueExample
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> q = new Queue<String>();
		System.out.println("Enter the size of queue");
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			System.out.println("Enter a string");
			q.enqueue(br.readLine());
		}
		System.out.println("Enter number of deletion");
		n = Integer.parseInt(br.readLine());
		int i = 0;
		while(i<n)
		{
			System.out.println(q.dequeue());
			i++;
		}
		System.out.println("Remaining Items");
		for(String t : q)
		{
			System.out.print(t+"\t");
		}
		System.out.println("\nExit");
	}
}