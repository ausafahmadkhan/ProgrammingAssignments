import java.io.*;
class StackExample
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> st = new Stack<String>();
		System.out.println("Enter the size of stack");
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			System.out.println("Enter a string");
			st.push(br.readLine());
		}
		System.out.println("Enter number of pops");
		n = Integer.parseInt(br.readLine());
		int i = 0;
		while(i<n)
		{
			System.out.println(st.pop());
			i++;
		}
		System.out.println("Exit");
	}
}