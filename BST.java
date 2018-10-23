class BST<Key extends Comparable<Key>,Value>
{
	private Node root;
	private class Node
	{
		Node left;
		Node right;
		Key key;
		Value val;
		int count;
		public Node(Key key, Value val)
		{
			this.key = key;
			this.val = val;
		}
	}
	public int size()
	{
		return size(root);
	}
	public int size(Node x)
	{
		if(x == null)
		{
			return 0;
		}
		else
		{
			return x.count;
		}
	}
	public void put(Key key, Value val)
	{
		root = put(root,key,val);
		
	}
	public Node put(Node x,Key key, Value val)
	{
		if(x == null)
		{
			Node t = new Node(key,val);
			t.count = 1;
			return t;
		}
		int cmp = (key).compareTo(x.key);
		if(cmp > 0)
		{
			x.right = put(x.right,key,val);
		}
		else if(cmp < 0)
		{
			x.left = put(x.left,key,val);
		}
		else
		{
			x.val = val;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	public Value get(Key key)
	{
		if(root == null)
		{
			return null;
		}
		else
		{
			Node x = root;
			while(x != null)
			{
				int cmp = key.compareTo(x.key);
				if(cmp > 0)
				{
					x = x.right;
				}
				else if(cmp < 0)
				{
					x = x.left;
				}
				else
				{
					return x.val;
				}
			}
			return null;
		}
	}
	public void delete(Key key)
	{
		root = delete(root,key);
	}
	public Node delete(Node x, Key key)
	{
		if(x == null)
		{
			return null;
		}
		int cmp = key.compareTo(x.key);
		if(cmp > 0)			x.right = delete(x.right,key);
		else if(cmp < 0)	x.left = delete(x.left,key);
		else
		{
			if(x.left == null)
			{
				return x.right;
			}
			else if(x.right == null)
			{
				return x.left;
			}
			else
			{
				Node tmp = min(x.right);
				delete(tmp.key);
				x.key = tmp.key;
				x.val = tmp.val;	
			}
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	public Node min(Node x)
	{
		while(x.left != null)
		{
			x = x.left;
		}
		return x;
	}
	public Iterable<Key> keys()
	{
		Queue<Key> q = new Queue<Key>();
		inorder(root,q);
		return q;
	}
	public void inorder(Node x,Queue<Key> q)
	{
		if(x == null)
		{
			return;
		}
		inorder(x.left,q);
		q.enqueue(x.key);
		inorder(x.right,q);
	}
	public int rank(Key key)
	{
		return rank(root,key);
	}
	public int rank(Node x, Key key)
	{
		if(x == null)		return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)		return rank(x.left,key);
		else if(cmp > 0)	return 1 + size(x.left) +rank(x.right,key);
		else	return size(x.left);
	}
	public static void main(String args[])
	{
		BST<String,Integer>  b = new BST<String,Integer>();
		b.put("Azam", 9);
		b.put("Ahmad", 2);
		b.put("Ausaf", 1);
		b.put("Nawaz", 1);
		b.put("Ahmad", 3);
		b.put("Khann", 6);
		b.put("Khan", 3);
		
		System.out.println(b.get("Azam"));
		System.out.println(b.get("Ahmad"));
		System.out.println("Size\t"+ b.size());
		System.out.println("Before del");
		for(String s : b.keys())
		{
			System.out.print(s+"\t");
		}
		b.delete("Ausaf");
		b.delete("Azam");
		System.out.println("\nAfter del");
		System.out.println("Size\t"+ b.size());
		for(String s : b.keys())
		{
			System.out.print(s+"\t");
		}
		System.out.println("\nRank of Nawaz is "+b.rank("Nawaz"));
		System.out.println("Rank of Ahmad is "+b.rank("Ahmad"));
	}
}