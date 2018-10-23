import java.util.*;
class Queue<Key> implements Iterable<Key>
{
	private Node head,tail;
	private class Node
	{
		Node next;
		Key item; 
	}
	public boolean isEmpty()
	{
		return head ==null;
	}
	public void enqueue(Key item)
	{
		Node tmp = new Node();
		tmp.item = item;
		if(isEmpty())
		{	
			head = tail = tmp;
		}
		else
		{
			tail.next = tmp;
			tail = tmp;
		}
	}
	public Key dequeue()
	{
		if(!isEmpty())
		{
			Key key = head.item;
			head = head.next;
			return key;
		}
		return null;
	}
	public Iterator<Key> iterator()
	{
		return new QueueIterator();
	}
	private class QueueIterator implements Iterator<Key>
	{
		private Node current = head;
		public boolean hasNext()
		{
			return current != null;
		}
		public Key next()
		{
			Key temp =  current.item;
			current = current.next;
			return temp;
		}
	}
}