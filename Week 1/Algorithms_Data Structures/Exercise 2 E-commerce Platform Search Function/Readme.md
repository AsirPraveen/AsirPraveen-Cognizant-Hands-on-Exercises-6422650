Big O Notation:
    1. Big O describes the upper bound of an algorithm's running time.
    2. It helps predict how performance degrades as input size increases.
    3. It ignores constants and lower-order terms to focus on growth rate.

Best, Average and Worst Case for Searching: 

      Linear Search - O(1) is best case, O(n/2) is avergae case and O(n) is worst case. 
      Binary Search - O(1) is best case, O(log n) is average case and O(log n) is worst case.

Analysis: 

Use binary search if:
    1. You can keep the product list sorted.
    2. You have a large number of products.

Use linear search if:
    1. The product list is small.
    2. Frequent insertions and deletions happen.
