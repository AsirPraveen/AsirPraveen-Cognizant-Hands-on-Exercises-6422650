Recursion:
    1. Recursion is a programming technique where a method calls itself to solve smaller instances of a problem.
    2. It's useful for problems that have a natural divide-and-conquer structure, like computing growth over time.

To calculate future value, we often use the compound interest formula:
              FV = PV*(1+r)^n
Where,
    FV = Future Value,
    PV = Present Value,
    r = Annual Growth rate
    n = Number of years
    
We can implement this recursively by:
        FV(n) = FV(n-1)*(1+r)
With Base Case:
        FV(0) = PV

Analysis:
   1. Time Complexity of Recursive version is O(n) (calls itself n times).
   2. Time Complexity of Iterative version is also O(n), but with no call stack overhead.
   3. It uses iteration or tail recursion to avoid Stack Overflow.
   4. It prefers iteration for simple linear recursions.
