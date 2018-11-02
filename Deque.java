import java.util.NoSuchElementException;
import java.util.Iterator;
public class Deque<Item> implements Iterable<Item>
{
	private Item ar[];
	private int size = 0;
	public Deque()
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
	public void addFirst(Item item)
	{
		if (item == null)
			throw new IllegalArgumentException("item cannot be empty");
		insert(0, item);
		size++;
		if (size == ar.length / 2)
			resize(2 * ar.length);
	}
	public void addLast(Item item)
	{
		if (item == null)
			throw new IllegalArgumentException("item cannot be empty");
		insert(size, item);
		size++;
		if (size == ar.length / 2)
			resize(2 * ar.length);
	}
	public Item removeFirst()
	{
		if (isEmpty())
			throw new NoSuchElementException("Empty Queue");
		Item i = ar[0];
		delete(0);
		size--;
		if (size == ar.length / 4)
			resize(ar.length / 2);
		return i;
	}
	public Item removeLast()
	{
		if (isEmpty())
			throw new NoSuchElementException("Empty Queue");
		Item i = ar[size - 1];
		delete(size - 1);
		size--;
		if (size == ar.length / 4)
			resize(ar.length / 2);
		return i;
	}
	public Iterator<Item> iterator()
	{
		return  new DequeIterator<Item>();
	}
	private class DequeIterator<Item> implements Iterator<Item>
	{
		int p = 0;
		public boolean hasNext()
		{
			return (p != size);
		}
		public Item next()
		{
			if (!hasNext())
				throw new NoSuchElementException("Empty Deque");
			Item t = (Item)ar[p];
			p++;
			return t;
		}
	}
	public static void main(String args[])
	{
		Deque<String> d = new Deque();
		d.addFirst("Ausaf");
		d.addLast("Khan");
		d.addFirst("Md");
		for(String s : d)
		{
			System.out.print(s+" ");
		}
		System.out.println();
		System.out.println(d.iterator().next());
		System.out.println(d.removeLast());
		System.out.println(d.size());
		System.out.println(d.removeLast());
		System.out.println(d.iterator().next());
		System.out.println(d.size());
	}
}