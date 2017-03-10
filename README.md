# San1c
Jonathan Quang, Edward Ro, Adeebur Rahman 

#Helpful Diagram
                                 1,2,3,4,5,6,7,8              -N comparisons done in this layer
                              1,2,3,4      5,6,7,8            -Pivot is called twice on half length subsections, which means N comparisons
                            1,2    3,4      5,6   7,8         - N comparisons done in this layer
                           1  2   3   4    5   6   7  8


#Best Case
The best case has a runtime of nlog(n) because the best case occurs when the partition index after running the pivot function always
returns the middle index between the lower and upper bound. Constant splitting in half results in log(n) splits. After each log(n) split,
that layer's calls to pivot results in n comparisons. Thus, O(nlog(n))

#Average Case
The average performance is also nlog(n) because given a section of an array, the partition index is likely near the middle index between
the lower and upper bound. The resulting split may have a small difference in length, but nothing too bad most of the time. Each layer of
log(n) splits has the pivot function do n comparisons regardless of the size of the sub sections. Hence, O(nlog(n)).

#Worst Case
The worst case scenario occurs when the pivot index we get causes a split that creates a subsection of length 1 and length n-1. If this
happens every single time, than there are n layers and n comparisons per layer. Therefore the worst case will be O(n^2). Look at the
diagram below:
          1,2,3,4,5  
          
          1  2,3,4,5  
          
          1  2   3,4,5 
          
          1  2  3  4,5  
          
          1  2  3  4  5 

#Methodology
##Quick Sort ALGORITHM:
   1. If bounds overlap stop.
   2. pick center of the bounds as the target index in the pivot function
   3. Call quick sort on the two parts produced by the partition index returned
      from the pivot function.
      
##Timing ALGORITHM:
  1. A random list of given size is created.
  2. The current time is recorded with System.nanoTime() as startTime
  3. The list is sorted with merge sort.
  4. Difference between the new value returned from System.nanoTime() and the startTime is returned.
  5. Process is repeated the given number of times.
  
  
##Data Analysis:
Take a look at our data here:
https://docs.google.com/document/d/135hokTsv0sx_aO1-ODnSnQAIwE1rGekAZzwXmq3DLdo/pub
We took the experimental time it took to complete the algorithim and compared it to the nlogn expected values. We are not looking
for differences of 0 because we do not know what coefficients are necessarily attached to nlogn. So we compare the differences
with the difference preceding it. The relative ratios should stabilize. You can see that as the data set increases in size,
the relative ratios begin to decrease at a decreasing rate, which means that it will eventually stabilize. This means that our
nlogn model is somewhat reasonable.

##Effects of pivot selection and data arrangement on execution time
 The pivot selection is important. If your pivot selection results in a partition index that is nowhere near the midpoint between the
 lower and upper bound, than you begin to approach a situation similar to the worst case scenario described above. If your pivot 
 selection results in a partition index close to the midpoint, then you begin to reach the best case. We don't necessarily know which
 pivot selection will result in a middle partition index. However, after applying the pivot function numerous times, the pivot selection
 tends to be close to the midpoint of the lower and upper bound, which is why we chose the pivot selection to be the midpoint between
 the lower and upperbound. There were arguments that a random pivot selection between the lower and upper bound was just as effective,
 though they were given up for the sake of making data analysis more consistent.

Data arrangment is important on execution time as well. Data that is closer to ascending order will result in more swaps being
performed, which takes up time.

