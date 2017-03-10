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
          1,2,3,4,5  \n
          1  2,3,4,5  \n 
          1  2   3,4,5 \n
          1  2  3  4,5  \n 
          1  2  3  4  5  \n
