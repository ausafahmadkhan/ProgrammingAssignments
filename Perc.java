class Perc
{
	int ar[][];
	int aux[];
	int size[];
	public Perc(int n)
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
		size = new int[n*n];
		for(int i = 0; i < aux.length; i++)
		{
			aux[i] = i;
			size[i] = 1;
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
		if(r1 == r2)	return;
		if(size[r1] < size[r2])	
		{
			aux[r1] = r2;
			size[r2] = size[r2] + size[r1];
		}
		else
		{
			aux[r2] = r1;
			size[r1] = size[r1] + size[r2];
		}
	}
	private boolean connected(int a, int b)
	{
		return root(a) == root(b);
	}
	public boolean isFull(int row, int col)
	{
		if(row< 0 || row >= ar.length || col < 0 || col >= ar.length)	return false;
		for(int i = 0; i < ar[0].length; i++)
		{
			if(isOpen(0,i) && isOpen(row, col))
			{
				if(connected(i, row * ar.length + col))		return true;
			}
		}
		return false;
	}
	public boolean percolates()
	{
		for(int i = 0; i < ar[0].length; i++)
		{
			if(isFull(ar.length -1, i))	return true;
		}
		return false;
	}
	public static void main(String args[])
	{
		Perc p = new Perc(5);
		p.open(3, 3);
		p.open(3, 2);
		p.open(0, 4);
		p.open(1, 4);
		p.open(2, 4);
		p.open(2, 3);
		//p.open(3, 1);
		//p.open(4, 1);
		//p.open(4, 4);
		p.open(2, 3);
		//p.open(4, 0);
		p.open(3, 0);
		p.open(2, 0);
		p.open(1, 0);
		p.open(0, 0);
		p.open(4, 2);
		for(int i = 0; i < p.ar.length; i++)
		{
			for(int j = 0; j < p.ar.length; j++)
			{
				System.out.print(p.ar[i][j] +"\t");
			}
			System.out.println();
		}
		System.out.println();
		for(int j = 0; j < p.aux.length; j++)
		{
			System.out.println(p.aux[j]);
		}
		System.out.println(p.isFull(3, 2));
		System.out.println(p.percolates());
	}
}