import java.util.*;
class Stack<Key> implements Iterable<Key>
{
	private Node top;
	private class Node
	{
		Key data;
		Node next;
	}
	public boolean isEmpty()
	{
		return top == null;
	}
	public void push(Key item)
	{
		if(isEmpty())
		{
			top = new Node();
			top.data = item;
		}
		else
		{
			Node temp = new Node();
			temp.data = item;
			temp.next = top;
			top = temp;
		}
	}
	public Key pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack Empty");
			return null;
		}
		else
		{
			Key val = top.data;
			top = top.next;
			return val;
		}
	}
	public Iterator iterator()
	{
		return new StackIterator();
	}
	public class StackIterator implements Iterator
	{
		Node current = top;
		public boolean hasNext()
		{
			return current != null;
		}
		public Key next()
		{
			Key temp = current.data;
			current = current.next;
			return temp;
		}
	}
}