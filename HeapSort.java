import java .io.*;
class HeapSort
{   private static int N;
    public void sink(Comparable[] ar,int k)
    {
        while(2*k <= N)
        {
            int j = 2*k;
            if(j<N && ar[j].compareTo(ar[j+1])>0)
            {
                j++;
            }
            if(ar[k].compareTo(ar[j])>0)
            {
                swap(ar,k,j);
            }
            else
            {
                break;
            }
            k=j;
        }
    }
    public void swap(Comparable ar[],int i, int j)
    {
        Comparable temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    public void sort(Comparable ar[])
    {
        for(int i = N/2; i >=1;i--)
        {
            sink(ar,i);
        }
        while(N >1)
        {
            swap(ar,1,N--);
            sink(ar,1);
        }
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the size of array");
        HeapSort h = new HeapSort();
        N= Integer.parseInt(br.readLine());
        Comparable ar[] = new Comparable[N+1];
        for(int i = 1; i <ar.length; i++)
        {
            System.out.println("Enter a num");
            ar[i] = Integer.parseInt(br.readLine());
        }
        System.out.println("Before sorting");
        for(int i = 1; i <ar.length; i++)
        {
            System.out.print(ar[i]+"\t");
        }
        System.out.println();
        System.out.println("After sorting\n");
        
        h.sort(ar);
        for(int i = 1; i <ar.length; i++)
        {
            System.out.print(ar[i]+"\t");
        }
    }
}