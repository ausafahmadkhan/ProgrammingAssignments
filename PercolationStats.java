import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
class PercolationStats
{
	private double frac[];
	private int t;
	public PercolationStats(int n, int trials)
	{
		if (n <= 0 || trials <= 0)
			throw new IllegalArgumentException("Invalid size or trials");
		t = trials;
		frac  = new double[trials];
		for (int i = 0; i < trials; i++)
		{	
			Percolation p = new Percolation(n);
			while (!p.percolates())
			{
				int row = StdRandom.uniform(n);
				int col = StdRandom.uniform(n);
				if (!p.isOpen(row, col))		p.open(row, col);
			}
			frac[i] = p.numberOfOpenSites() * 1.0 / (n*n);
		}
	}
	public double mean()
	{
		return StdStats.mean(frac);
	}
	public double stddev()
	{
		return StdStats.stddev(frac);
	}
	public double confidenceLow()
	{
		return mean() - (1.96 * stddev() / Math.sqrt(t));
	}
	public double confidenceHigh()
	{
		return mean() + (1.96 * stddev() / Math.sqrt(t));
	}
	public static void main(String args[])
	{
		PercolationStats ps = new PercolationStats(5,1000);
		System.out.println("mean\t= " + ps.mean());
		System.out.println("stddev\t= " + ps.stddev());
		System.out.println("95% confidence interval\t= ["+ps.confidenceLow()+","+ps.confidenceHigh()+"]");
	}
}