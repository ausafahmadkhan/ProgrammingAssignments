import java.io.*;
class MaxPQ<Key extends Comparable<Key>>
{
  private Key pq[];
  private int N;
  public MaxPQ(int capacity)
  {
    pq = (Key[])new Comparable[capacity+1];        //generic array creation not allowed in Java
  }
  public boolean isEmpty()
  {
    return N == 0;
  }
  public void swim(int k)
  {
    while(k>1)
    {
      if(pq[k].compareTo(pq[k/2])>0)
      {
        swap(pq,k,k/2);
      }
      k = k/2;
    }
  }
  public void sink(int k)
  {
    while(2*k <=N)
    {
      int j = 2*k;
      if(j<N && pq[j].compareTo(pq[j+1]) < 0)
      {
        j = j+1;
      }
      if(pq[k].compareTo(pq[j])<0)
      {
        swap(pq,k,j);
      }
      else
      {
        break;
      }
      k = j;
    }
  }
  public void insert(Key item)
  {
    pq[++N] = item;
    swim(N);
  }
  public Key delMax()
  {
    Key temp = pq[1];
    swap(pq,1,N);
    pq[N--] = null;
    sink(1);
    return temp;
  }
  public void swap(Comparable a[],int i, int j)
    {
        Comparable temp = a[i];
        a[i]=a[j];
        a[j]=temp; 
    }
  public static void main(String args[])throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter the size of heap");
    int size = Integer.parseInt(br.readLine());
    MaxPQ m = new MaxPQ(size);
    for(int i = 0; i<size;i++)
    {
      System.out.println("Enter a val");
      m.insert(Integer.parseInt(br.readLine()));
    }
    Comparable t = m.delMax();
    System.out.println("1st del \n"+t);
    t = m.delMax();
    System.out.print("2nd del\n"+t);
  }
}