//Adeebur Rahman, Jonathan Quang, Edward Ro
//APCS2 p1
//Lab01 -- What Does the Data Say? And how?
//2017-03-09

/*======================================
  class QuickSortTester

  Quick Sort ALGORITHM:
  1. If array size is 1, return array
  2. Else, split the array into halves (first half is smaller if array size is odd)
  3. Sort each half of the array and merge the two halves

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(nlog(n))

  Timing ALGORITHM:

  1. A random list of given size is created.
  2. The current time is recorded with System.nanoTime() as startTime
  3. The list is sorted with merge sort.
  4. Difference between the new value returned from System.nanoTime() and the startTime is returned.
  5. Process is repeated the given number of times.

  Mean execution times for dataset of size n:
  Batch size: 1000
  Array Length, Average Runtime
  50000,7517099
  100000,13816947
  150000,22607216
  200000,30941182
  250000,40110985
  300000,48643904
  350000,57730321
  400000,65441816
  450000,73281588
  500000,84680403
  550000,94165978
  600000,99916277
  650000,109352105
  700000,122540827
  750000,130717364
  800000,138727958
  850000,148570851
  900000,159042963
  950000,165009158
  1000000,181331154

  Sidenote

  After running multiple runtime tests, we noticed that the runtime of the first few executions of MergeSort were significantly larger than runtimes of successive executions. We found that this is because java was still initializing. In order to get more accurate data, we added another set of tests of size 10000000 that does not get displayed on the terminal, so that the successive runtimes are more accurate. We used size 10000000 because this properly fixed the runtimes. When we tried shorter lists it didn't really have much of an effect. 
  
  ANALYSIS:
  In order to get some data, we calculated the average runtime of lists between size 50000 and 1000000 with increments of 50000. We then took the average runtimes and graphed them. We also graphed n, log(n), nlog(n), and n^2 runtime for comparison. The graph looked most similar to nlog(n). To confirm the runtime, we graphed lines of xnlog(n) replacing x with some arbitray number to see if it was close to matching. We also graphed lines of xlog(n) and xn to compare. From our testing we found that our data is most closely represented by the line 13nlog(n). We then concluded that the runtime of merge sort is nlog(n).
     
     

  ======================================*/

public class QuickSortTester 
{

    public static int[] randArr(int length) {
	int[] retArr = new int[length];
	for (int i = 0; i < length; i++) {
	    retArr[i] = (int) (Math.random()*100);
	}
	return retArr;
    }

    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }

    public static long getTime(int[] a) {
	long startTime = System.nanoTime();
	QuickSort.qsort(a);
	return System.nanoTime() - startTime;
    }
    
    public static long calcRuntime(int arraySize, int numTests) {
	long total = 0;
	for (int i = 0; i < numTests; i++) {
	    int[] a = randArr(arraySize);
	    total += getTime(a);
	}
	return total / numTests;
    }

    /******************************
     * execution time analysis 
       1. Random Array of given size generated.
       2. Time recorded prior to sorting.
       3. Array sorted
       4. runtime added to variable
       5. process repeated the given numTests
       6. total / numTests returned
    ******************************/
    public static void main( String[] args ) {

	calcRuntime(500000,100); //to get rid of runtimes when java is warming up.
	
	System.out.println("Length\t\tRuntime");
	for (int i = 50000; i <= 500000; i+=50000) {
	    System.out.print(i + "\t\t");
	    System.out.println(calcRuntime(i,100));
	}
	
    }//end main

}//end class
