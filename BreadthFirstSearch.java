class BreadthFirstSearch
{
	private boolean marked[];
	private int edgeTo[];
	Queue<Integer> q;
	public BreadthFirstSearch(Graph g)
	{
		marked = new boolean[g.V];
		for(int i = 0; i< marked.length;i++)
		{
			marked[i] = false;
		}
		edgeTo = new int[g.V];
		for(int i = 0; i< edgeTo.length;i++)
		{
			edgeTo[i] = -1;
		}
		q = new Queue<Integer>();
	}
	public void bfs(Graph g,int s)
	{
		q.enqueue(s);
		marked[s] = true;
		while(!q.isEmpty())
		{
			int t = q.dequeue();
			System.out.println(t);
			for(int i : g.adj(t))
			{
				if(!marked[i])
				{
					q.enqueue(i);
					marked[i] = true;
					edgeTo[i] = t;
				}
			}
		}
	}
}