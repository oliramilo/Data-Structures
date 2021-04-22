import java.util.*;
/**
** Software Technology 152
** Class to hold various static sort methods.
*/
class Sorts
{
    // bubble sort
    public static void bubbleSort(int[] A)
    {
        for (int i = 0;i<A.length-1;i++)
        {
            for(int ii=0;ii<A.length-i-1;ii++)
            {
                if(A[ii] > A[ii+1])
                {
                    int temp = A[ii];
                    A[ii] = A[ii+1];
                    A[ii+1] = temp;
                }
            }
        }
    }

    // selection sort
    public static void selectionSort(int[] A)
    {
       int smallest;
       for(int i = 0;i<A.length;i++)
       {
           smallest = i;
           for (int ii = i+1; ii<A.length;ii++)
           {
               if(A[ii] < A[smallest])
               {
                   smallest = ii;
               }
           }
           int temp = A[smallest];
           A[smallest] = A[i];
           A[i] = temp;
       }

    }

    // insertion sort
    public static void insertionSort(int[] A)
    {
      for (int i = 1;i<A.length;i++)
      {
          int j = i-1;
          int temp = A[i];
          while(j>= 0 && A[j] > temp)
          {
              A[j+1] = A[j];
              j -=1;
          }
          A[j+1] = temp;
      }
    }

    // mergeSort - front-end for kick-starting the recursive algorithm
    public static void mergeSort(int[] A)
    {
        mergeSortRecurse(A,0,A.length-1);
    }

    private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        if(leftIdx < rightIdx)
        {
            int midIdx = (leftIdx+rightIdx)/ 2;
            mergeSortRecurse(A,leftIdx,midIdx);
            mergeSortRecurse(A,midIdx+1,rightIdx);

            merge(A,leftIdx,midIdx,rightIdx);
        }
    }

    private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx)
    {
        int i,j,k;
        int n1 = midIdx - leftIdx + 1;
        int n2 = rightIdx - midIdx;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(i=0;i<n1;i++)
        {
            L[i] = A[leftIdx+i];
        }
        for(j=0;j<n2;j++)
        {
            R[j] = A[midIdx + 1 + j];
        }

        i = 0;
        j = 0;
        k = leftIdx;

        while(i<n1 && j <n2)
        {
            if(L[i] <= R[j])
            {
                A[k] = L[i];
                i++;
            }
            else
            {
                A[k] = R[j];
                j++;
            }
            k++;
        }

            while(i<n1)
            {
                A[k] = L[i];
                i++;
                k++;
            }

            while(j<n2)
            {
                A[k] = R[j];
                j++;
                k++;
            }
    }


    // quickSort - front-end for kick-starting the recursive algorithm
    public static void quickSort(int[] A)
    {
        quickSortRecurse(A,0,A.length-1);
    }//quickSort()
    private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx)
    {
        if(rightIdx >= leftIdx)
        {
            int pivotIdx = (leftIdx + rightIdx) / 2;
            int newPivotIndex = doPartitioning(A,leftIdx,rightIdx,pivotIdx);

            quickSortRecurse(A,leftIdx,newPivotIndex-1);
            quickSortRecurse(A,newPivotIndex+1,rightIdx);
        }

    }//quickSortRecurse()
    private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx)
    {
        int pivotVal = A[pivotIdx];
        A[pivotIdx] = A[rightIdx];
        A[rightIdx] = pivotVal;
        int currentIdx = leftIdx;

        for(int ii = leftIdx;ii<rightIdx-1;ii++)
        {
            if(A[ii] < pivotVal)
            {
                int temp = A[ii];
                A[ii] = A[currentIdx];
                A[currentIdx] = temp;
                currentIdx = currentIdx +1;
            }
        }
        int newPivotIndex = currentIdx;
        A[rightIdx] = A[newPivotIndex];
        A[newPivotIndex] = pivotVal;
    	return newPivotIndex;	// TEMP - Replace this when you implement QuickSort
    }//doPartitioning

}//end Sorts calss
