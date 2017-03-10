//Adeebur Rahman, Jonathan Quang, Edward Ro
//APCS2 p1
//Lab01 -- What Does the Data Say? And how?
//2017-03-09

/*======================================
  class QuickSortTester

  Quick Sort ALGORITHM:
   1. If bounds overlap stop.
   2. pick center of the bounds as the target index in the pivot function
   3. Call quick sort on the two parts produced by the partition index returned
      from the pivot function.

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
  Length	Runtime
  50000		13274452
  100000	49017350
  150000	107338013
  200000	187887482
  250000	292365332
  300000	416992099
  350000	566807509
  400000	736323756
  450000	935191968
  500000	1147860514

  Sidenote

  After running multiple runtime tests, we noticed that the runtime of the first few
 executions of QuickSort were significantly larger than runtimes of successive 
 executions. We found that this is because java was still initializing. To resolve
 this issue, we run a set of tests of size 10000000 that does not get displayed
 in the terminal.


  
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
