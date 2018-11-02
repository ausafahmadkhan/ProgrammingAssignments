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
			throw new IllegalArgumentException("item cannot be empty");
		if (size == ar.length / 2)
			resize(2 * ar.length);
		insert(0,item);
		size++;
	}
	public Item dequeue()
	{
		if (isEmpty())
			throw new NoSuchElementException("Empty Queue");
		if (size == ar.length / 4)
			resize(ar.length / 2);
		int t = StdRandom.uniform(0, size);
		Item item = ar[t];
		delete(t);
		size--;
		return item;
	}
	private void swap(int a, int b)
	{
		if (isEmpty())
			throw new NoSuchElementException("Empty Queue");
		Item i = ar[a];
		ar[a] = ar[b];
		ar[b] = i;
	}
	public Item sample()
	{
		if (isEmpty())
			throw new NoSuchElementException("Empty Queue");
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
			if (!hasNext())
				throw new NoSuchElementException("Empty Deque");
			int t = StdRandom.uniform(0, f);
			Item item = (Item)ar[t];
			swap(--f,t);
			return item;
		}
	}
	public static void main(String args[])
	{
		RandomizedQueue<Integer> r = new RandomizedQueue<Integer>();
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