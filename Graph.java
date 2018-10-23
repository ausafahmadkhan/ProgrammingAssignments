import java.util.*;
public class Graph
{
	public int V;
	private Stack<Integer> st[];
	public Graph(int V)
	{
		this.V = V;
		st = (Stack<Integer>[])new Stack[V];
		for(int i = 0;i<V;i++)
		{
			st[i]= new Stack<Integer>();
		}
	}
	public void addEdge(int v,int w)
	{
		st[v].push(w);
		st[w].push(v);
	}
	public Iterable<Integer> adj(int v)
	{
		return st[v];
	}
}