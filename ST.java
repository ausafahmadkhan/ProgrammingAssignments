import java.util.*;
class ST<Key extends Comparable<Key>,Value> implements Iterable<Key>
{
	private Node head;
	private class Node
	{
		Node next;
		Key key;
		Value val;
	}
	public boolean contains(Key key)
	{
		Node temp = head;
		while(temp!= null)
		{
			if(temp.key == key) return true;
			else	temp = temp.next;
		}
		return false;
	}
	public void put(Key key,Value val)
	{
		if(contains(key))
		{
			Node temp = head;
			if(temp.key == key)
			{
				temp.val = val;
			}
			temp = temp.next;
		}
		else
		{
			Node temp = new Node();
			temp.key = key;
			temp.val = val;
			temp.next = head;
			head = temp;
		}
	}
	public Value get(Key key)
	{
		Node temp = head;
		while(temp != null)
		{
			if (temp.key==key) 
				return temp.val;
			temp = temp.next;
		}
		return null;
	}
	public Iterator<Key> iterator()
	{
		return (new STiterator());
	}
	public class STiterator implements Iterator<Key>
	{
		private Node current = head;
		public boolean hasNext()
		{
			return current!= null;
		}
		public Key next()
		{
			Key temp =  current.key;
			current = current.next;
			return temp;
		}
	}
	public static void main(String args[])
	{
		ST<Integer,String> s = new ST<Integer,String>();
		s.put(1,"Ausaf");
		s.put(2,"Ahmad");
		s.put(3,"Khan");
		System.out.println(s.contains(2));
		System.out.println(s.contains(6));
		System.out.println(s.get(3));
		for(int st : s)
		{
			System.out.println(st +"\t"+ s.get(st));
		}
	}
}