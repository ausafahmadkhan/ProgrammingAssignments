//nlogn - time complexity

import java.io.*;
class QuickSort
{
    public int partition(int ar[],int low,int high)
    {
        int l = low+1,h=high;
        while(true)
        {
            while(ar[l]<=ar[low])
            {
                l++;
                if(l==high)     break;
            }
            while(ar[h]>=ar[low]) 
            {
                h--;
                if(h==low)      break;
            }
            if(l>=h)        break;
            swap(ar,l,h);
        }
        swap(ar,low,h);
        return h;
    }
    public void swap(int a[],int i, int j)
    {
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp; 
    }
    public void sort(int ar[],int low,int high)
    {
        if(low >= high)     return;
        int p = partition(ar,low,high);
        sort(ar,low,p-1);
        sort(ar,p+1,high);
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Quick Sort\nEnter n");
        int n = Integer.parseInt(br.readLine());
        int ar[] = new int[n];
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
        QuickSort q = new QuickSort();
        q.sort(ar,0,n-1);
        System.out.println("After Sorting");
        for(int i =0;i<n;i++)
        {
            System.out.print(ar[i]+"\t");
        }
    }
}