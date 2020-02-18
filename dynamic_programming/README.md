# Dynamic Programming

## Link
- https://leetcode.com/discuss/general-discussion/475924/My-experience-and-notes-for-learning-DP

## MIT course 
[19. Dynamic Programming I: Fibonacci, Shortest Paths](https://www.youtube.com/watch?v=OQ5jsbhAv_M&t=1741s)

- Idea: 
  - DP likes careful brite force
  - DP likes subproblems + "reuse"

- Fibonacci numbers
```Fn = Fn-1 + Fn-2```
```F0 = 0 and F1 = 1```
  - Native recursive algorithm
 
 ```
def Fibonacci(n): 
    if n<0: 
        print("Incorrect input") 
    # First Fibonacci number is 0 
    elif n==0: 
        return 0
    # Second Fibonacci number is 1 
    elif n==1: 
        return 1
    else: 
        return Fibonacci(n-1)+Fibonacci(n-2) 
print(Fibonacci(9))  
 ```
EXPONENTIAL time

Memoirzed DP algorithm

### memorization & subproblem
  - memo
  ```
 fib(n) 
    if n in memo: return memo[n]
    if n<=2L f =1
    else f = fib(n-1) + fib(n-2)
    memo[n] = f
    return f
 ```          
[Recursion tree for execution of fib(5)](https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/)

fib(k) only recurses the first time it's called 
- memoized calls
- nonrecursive work per call  -> time = f(n)

- memoize (*remember*) & re-use solutions to subproblems that help solve the problem




  
Dynamic Programing:

Pattern
			
Minimum/Maximum Path to Reach a Target.
Distinct Ways
Merging Intervals
DP on Strings
Decision Making 


Choose minimum (maximum) path among all possible path before the current state, then add value for the current state.

route[i] = min(routes[i-1], routes[i-2], …, routes[i-k], routes[]) + cost[i]
