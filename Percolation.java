public class Percolation
{
	private int ar[][];
	private int parent[];
	private int size[];
	private int count = 0;
	public Percolation(int n)
	{
		if(n <= 0)	throw new IllegalArgumentException("Invalid size");
		ar = new int[n+1][n+1];
		for (int i = 0; i < ar.length; i++)
		{
			for (int j = 0; j < ar.length; j++)
			{
				ar[i][j] = 0;
			}
		}
		parent = new int[ar.length * ar.length];
		size = new int[ar.length * ar.length];
		for (int i = 0; i < parent.length; i++)
		{
			parent[i] = i;
			size[i] = 1;
		}
	}
	public void open(int row, int col)
	{
		if(!isOpen(row, col))
		{	
			if (row <= 0 || row >= ar.length || col <= 0 || col >= ar.length)	
				throw new IllegalArgumentException("Invalid index");
			ar[row][col] = 1;
			if (col-1 > 0 && col-1 < ar.length && isOpen(row,col-1))	
				union(row * ar.length + col, row * ar.length +col -1);
			if (row-1 > 0 && row-1 < ar.length && isOpen(row-1,col))	
				union(row * ar.length + col, (row-1) * ar.length +col);
			if (col+1 > 0 && col+1 < ar.length && isOpen(row,col+1))	
				union(row * ar.length + col, row * ar.length +col +1);
			if (row+1 > 0 && row+1 < ar.length && isOpen(row+1,col))	
				union(row * ar.length + col, (row+1) * ar.length +col);
			if (row == 1)	
				union(row * ar.length + col, 0);
			if (row == ar.length -1)	
				union(row * ar.length + col, 1);
			count++;
		}
	}
	public boolean isOpen(int row, int col)
	{
		if (row <= 0 || row >= ar.length || col <= 0 || col >= ar.length)
			throw new IllegalArgumentException("Invalid index");
		return ar[row][col] == 1;
	}
	private int root(int i)
	{
		while (parent[i] != i)
		{
			i = parent[i];
		}
		return i;
	}
	private void union(int a, int b)
	{
		int r1 = root(a);
		int r2 = root(b);
		if (r1 == r2)	return;
		if (size[r1] < size[r2])	
		{
			parent[r1] = r2;
			size[r2] = size[r2] + size[r1];
		}
		else
		{
			parent[r2] = r1;
			size[r1] = size[r1] + size[r2];
		}
	}
	private boolean connected(int a, int b)
	{
		return root(a) == root(b);
	}
	public boolean isFull(int row, int col)
	{
		if (row <= 0 || row >= ar.length || col <= 0 || col >= ar.length)	
			throw new IllegalArgumentException("Invalid index");
		if (connected(row * ar.length + col, 0))	return true;
		return false;
	}
	public boolean percolates()
	{
		return (connected(0, 1));
	}
	public int numberOfOpenSites()
	{
		return count;
	}
	public static void main(String args[])
	{
		Percolation p = new Percolation(5);
		p.open(3, 3);
		p.open(3, 2);
		p.open(2, 4);
		p.open(2, 3);
		p.open(4, 1);
		p.open(1, 1);
		p.open(2, 1);
		p.open(3, 1);
		p.open(5, 1);
		p.open(4, 3);
		p.open(5, 3);
		p.open(1, 4);
		
		for (int i = 0; i < p.ar.length; i++)
		{
			for (int j = 0; j < p.ar.length; j++)
			{
				System.out.print(p.ar[i][j] +"\t");
			}
			System.out.println();
		}
		System.out.println();
		for (int j = 0; j < p.parent.length; j++)
		{
			System.out.println(p.parent[j]);
		}
		System.out.println(p.isFull(3, 1));
		System.out.println(p.count +" open sites" );
		System.out.println(p.percolates());
	}
}