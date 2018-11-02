import edu.princeton.cs.algs4.StdRandom;
import java.util.NoSuchElementException;
import java.util.Iterator;
public class RandomizedQueue<Item> implements Iterable<Item>
{
	private Item ar[];
	private int size = 0;
	public RandomizedQueue()
	{
		ar = (Item[]) new Object[10];
	}
	public boolean isEmpty()
	{
		return size == 0;
	}
	public int size()
	{
		return size;
	}
	private void resize(int n)
	{
		Item arr[] = (Item[]) new Object[n];
		for (int i = 0; i < size; i++)
		{
			arr[i] = ar[i];
		}
		ar = arr;
	}
	private void insert(int i, Item item)
	{
		int t = size;
		while (t > i)
		{
			ar[t] = ar[t-1];
			t--;
		}
		ar[i] = item;
	}
	private void delete(int i)
	{
		while (i + 1 < size)
		{
			ar[i] = ar[i + 1];
			i++;
		}
	}
	public void enqueue(Item item)
	{
		if (item == null)
			throw new NullPointerException("item cannot be empty");
		insert(0,item);
		size++;
		if (size == ar.length / 2)
			resize(2 * ar.length);
	}
	public Item dequeue()
	{
		if (isEmpty())
			throw new NoSuchElementException("Empty Queue");
		int t = StdRandom.uniform(0, size);
		Item item = ar[t];
		delete(t);
		size--;
		if (size == ar.length / 4)
			resize(ar.length / 2);
		return item;
	}
	private void swap(int a, int b)
	{
		Item i = ar[a];
		ar[a] = ar[b];
		ar[b] = i;
	}
	public Item sample()
	{
		int t = StdRandom.uniform(0, size);
		Item item = ar[t];
		return item;
	}
	public Iterator<Item> iterator()
	{
		return new RandomizedIterator<Item>();
	}
	private class RandomizedIterator<Item> implements Iterator<Item>
	{
		int f = size;
		public boolean hasNext()
		{
			return f != 0;
		}
		public Item next()
		{
			int i = StdRandom.uniform(0, f);
			Item t = (Item)ar[i];
			swap(i,--f);
			return t;
		}
	}
	public static void main(String args[])
	{
		RandomizedQueue<Integer> r = new RandomizedQueue();
		for (int i = 0; i < 10; i++)
		{
			r.enqueue(i);
		}
		System.out.println(r.size());
		for (Integer i : r)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(r.size());
		for (Integer i : r)
		{
			System.out.print(i + " ");
		}
		System.out.println("\n" + r.dequeue());
		System.out.println();
		System.out.println(r.size());
		for (Integer i : r)
		{
			System.out.print(i + " ");
		}
		System.out.println("\n" + r.dequeue());
		System.out.println();
		System.out.println(r.size());
		for (Integer i : r)
		{
			System.out.print(i + " ");
		}
	}
}