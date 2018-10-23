public class GraphExample 
{
	public static void main(String args[])
	{
		Graph g = new Graph(7);
		g.addEdge(1, 4);
		g.addEdge(3, 4);
		g.addEdge(1, 2);
		g.addEdge(2, 5);
		g.addEdge(2, 6);
		g.addEdge(1, 3);
		System.out.println("Adjacent vertices");
		for(int i : g.adj(1))
		{
			System.out.println(i+"-1");
		}
		System.out.println("DFS traversal");
		DepthFirstSearch d = new DepthFirstSearch(g);
		d.DFS(g, 1);
		
		System.out.println("path between source and 4");
		for(int i : d.paths(4, 1))
		{
			System.out.print(i+"\t");
		}
		System.out.println("\nBFS traversal");
		BreadthFirstSearch b = new BreadthFirstSearch(g);
		b.bfs(g, 1);
	}
}
