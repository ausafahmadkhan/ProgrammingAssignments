class DepthFirstSearch
{
	public boolean marked[];
	public int edgeTo[];
	public DepthFirstSearch(Graph G)
	{
		marked = new boolean[G.V];
		edgeTo = new int[G.V];
		for(int i = 0;i < marked.length;i++)
		{
			marked[i] = false;
		}
		for(int i = 0;i < edgeTo.length;i++)
		{
			edgeTo[i] = -1;
		}
	}
	public void DFS(Graph g, int s)
	{
		marked[s] = true;
		System.out.println(s);
		for(int w : g.adj(s))
		{
			if(!marked[w])
			{
				DFS(g,w);
				edgeTo[w] = s;
			}
		}
	}
	public boolean hasPath(int v)
	{
		return marked[v] == true;
	}
	public Iterable<Integer> paths(int v,int s)
	{
		if(!hasPath(v))	return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int i = v; i != s; i = edgeTo[i])
		{
			path.push(i);
		}
		path.push(s);
		return path;
	}
}