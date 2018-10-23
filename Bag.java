import java.util.*;
public class Bag<Key> implements Iterable<Key> 
{
	ArrayList<Key> ar;
	public Bag()
	{
		ar = new ArrayList<Key>();
	}
	public void add(Key key)
	{
		ar.add(key);
	}
	public Iterator<Key> iterator()
	{
		return ar.iterator();
	}
}
