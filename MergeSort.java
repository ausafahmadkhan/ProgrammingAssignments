//nlogn - time complexity


import java.io.*;
class MergeSort
{
    public Comparable aux[];
    public void sort(Comparable a[],int low,int high)
    {
        if(high<=low)
            return;
        int mid = low+(high - low)/2;
        sort(a,low,mid);
        sort(a,mid+1,high);
        merge(a,mid,low,high);
    }
    public void sort(Comparable a[])
    {
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    public void merge(Comparable a[],int mid,int low,int high)
    {
        
        for(int i = low;i <=high;i++)
        {
            aux[i] = a[i];
        }
        int j=low,k=mid+1;
        for(int i = low;i<=high;i++)
        {
            if(k>high)
            {
                a[i] = aux[j];
                j++;
            }
            else if(j>mid)
            {
                a[i] = aux[k];
                k++;
            }
            else if(aux[j].compareTo(aux[k]) < 1)
            {
                a[i] = aux[j];
                j++;
            }
            else if(aux[j].compareTo(aux[k]) >=0)
            {
                a[i] = aux[k];
                k++;
                       
            }
        }
    }
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Merge Sort\nEnter n");
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
        MergeSort m = new MergeSort();
        m.sort(ar);
        System.out.println("After Sorting");
        for(int i =0;i<n;i++)
        {
            System.out.print(ar[i]+"\t");
        }
    }
}