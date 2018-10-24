class Percolation
{
	int ar[][];
	int aux[];
	public Percolation(int n)
	{
		ar = new int[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				ar[i][j] = 0;
			}
		}
		aux = new int[n*n];
		for(int i = 0; i < aux.length; i++)
		{
			aux[i] = i;
		}
	}
	public void open(int row, int col)
	{
		ar[row][col] = 1;
		if(isOpen(row,col-1))	union(row * ar.length + col, row * ar.length +col -1);
		if(isOpen(row-1,col))	union(row * ar.length + col, (row-1) * ar.length +col);
		if(isOpen(row,col+1))	union(row * ar.length + col, row * ar.length +col +1);
		if(isOpen(row+1,col))	union(row * ar.length + col, (row+1) * ar.length +col);

	}
	public boolean isOpen(int row, int col)
	{
		if(row < 0 || row >= ar.length || col < 0 || col >= ar.length) return false;
		return ar[row][col] == 1;
	}
	private int root(int i)
	{
		while(aux[i] != i)
		{
			i = aux[i];
		}
		return i;
	}
	private void union(int a, int b)
	{
		int r1 = root(a);
		int r2 = root(b);
		if(a / ar.length == 0)	aux[r2] = r1;
		else	aux[r1] = r2; 
	}
	public boolean isFull(int row, int col)
i	{
		if(row< 0 || row >= ar.length || col < 0 || col >= ar.length)	return false;
		int t = row * ar.length + col;
		while(root(t) != t)		t = root(t);
		return (t / ar.length == 0);
	}
	public static void main(String args[])
	{
		Percolation p = new Percolation(5);
		p.open(4, 4);
		p.open(1, 4);
		p.open(2, 4);
		p.open(2, 3);
		p.open(3, 3);
		p.open(3, 2);
		p.open(4, 3);
		p.open(4, 1);
		p.open(0, 4);
		for(int i = 0; i < p.ar.length; i++)
		{
			for(int j = 0; j < p.ar.length; j++)
			{
				System.out.print(p.ar[i][j] +"\t");
			}
			System.out.println();
		}
		for(int j = 0; j < p.aux.length; j++)
		{
			System.out.println(p.aux[j]);
		}
		System.out.println(p.isFull(4, 4));
	}
}
