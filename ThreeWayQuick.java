import java.io.*;
class ThreeWayQuick
{
  public void sort(Comparable ar[], int low, int high)
  {
    if(high<=low)  return;
    int lt = low, gt = high;
    int i = low+1;
    Comparable p = ar[low];
    while(gt >= i)
    {
      if(ar[i].compareTo(p) < 0)
      {
        swap(ar,lt,i);
        i++;lt++;
      }
      else if(ar[i].compareTo(p) > 0)
      {
        swap(ar,gt,i);
        gt--;
      }
      else
      {
        i++;
      }
    }
    sort(ar,low,lt-1);
    sort(ar,gt+1,high);
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
        System.out.println("3 way Quick Sort\nEnter n");
        int n = Integer.parseInt(br.readLine());
        Comparable ar[] = new Comparable[n];
        for(int i =0;i<n;i++)
        {
            System.out.println("Enter value");
            ar[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Before Sorting");
        for(int i =0;i<n;i++)
        {
            System.out.print(ar[i]+"\t");
        }
        System.out.println();
        ThreeWayQuick t = new ThreeWayQuick();
        t.sort(ar,0,ar.length-1);
        System.out.println("After Sorting");
        for(int i =0;i<n;i++)
        {
            System.out.print(ar[i]+"\t");
        }
    }
}
    
        