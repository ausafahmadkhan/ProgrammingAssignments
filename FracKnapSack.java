import java.util.*;
class FracKnapSack
{
	private Item it[];
	private class Item
	{
		int val;
		int weight;
		double cost;
		public Item(int val, int weight)
		{
			this.val = val;
			this.weight = weight;
			this.cost = val/weight;
		}
	}
	public void knapSack(int val[],int weight[],int W)
	{
		Item temp;
		int s = 0,j=0;
		int knapVal = 0;
		int l = val.length;
		it = new Item[l];
		for(int i = 0; i < l; i++)
		{
			temp = new Item(val[i],weight[i]);
			it[i] = temp;
		}
		ItemComparator c = new ItemComparator();
		Arrays.sort(it, c);
		while(s < W)
		{
			knapVal = knapVal + it[j].val;
			s = s + it[j].weight;
			j++;
		}
		j--;
		s = s - it[j].weight;
		knapVal = knapVal - it[j].val;
		knapVal = knapVal + ((W - s) * (int)it[j].cost);
		System.out.println("The Knapsack value is "+ knapVal);
	}
	private class ItemComparator implements Comparator<Item>
	{
		public int compare(Item a, Item b)
		{
			if(a.cost > b.cost) return -1;
			else if(a.cost < b.cost) return 1;
			else return 0;
		}
	}
	public static void main(String args[])
	{
		int val[] = {40,75,60};
		int weight[] = {10,15,20};
		FracKnapSack ks = new FracKnapSack();
		ks.knapSack(val,weight, 40);
	}
}