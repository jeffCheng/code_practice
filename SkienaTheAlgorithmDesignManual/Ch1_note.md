# Introduction to Algorithm Design

An algorithm is a procedute to accomplish a specific task.
a problem 
an instance of probelm 

Probelm: Sorting
Input: A sequence of n keys a1, ... , a2
Output: The permuation(reordering) of the input sequence such that a'1 <= a'2 <= ... <= a'n-1 <= a'n

Instance of sorting: [222,331, 322,1123]

Insertion Sorting
Start with a single element and then incrementlally inserts the remaining elements so that the list stays sorted.

```
class InsertionSort{
    public insertionsort(int[] nums){
        int n = nums.length;
        int j=0;
        for(int i=1;i<n;i++){
            j = i;
            while(j>0 && nums[j] <nums[j-1]){
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j = j-1;
            }
        }
    }
}
```
Foucs on the correctness

Robot Tour Optimzation 

Problem: Robot Tour Optimization
Input: A set S of n points in the plane
Output: What is the shortest cycle tour that visits each point in the set S?

NearestNeighbor(P)
    Pick and visit an initial point p0 from Pick
    p =p0
    i = 0
    While there are still unvisited points
        i = i+1
        Select pi to be the closest unvisited point to pi-1
        Visit pi 
    Return to Po from Pn-1

Wrong: 
When we start from the point ‘0’ and repeatedly walk to the nearest
unvisited neighbor, we might keep jumping left-right-left-right over ‘0’ as the algorithm offers no advice on how to break ties


A different idea might be to repeatedly connect the closest pair of endpoints
whose connection will not create a problem, such as premature termination of the
cycle

 Each vertex begins as its own single vertex chain. After merging everything
together, we will end up with a single chain containing all the points in it.

ClosestPair(P)
    Let n be the number of points in set P.
    For i =1 to n-1 do 
        d = infi
        For each pair of endpoints (s, t) from distinct vertex chains 
            if dist(s, t) <= d then sm = s, tm= t and d = dist(s,t)
        Connect(sm ,tm ) by an edge
    Connect the two endpoints by an edge


Thus this second algorithm is also wrong. Which one of these algorithms performs better? You can’t tell just by looking at them. Clearly, both heuristics can
end up with very bad tours on very innocent-looking input.

OptimalTSP(P)
    d = infi
    For each of the n! permuations Pi of point set Pi  
        If(cost(Pi)<=d) then d = cost(Pi) and Pmin = Pi
    Return Pmin

```
# Python3 implementation of the approach 
V = 4
answer = [] 
  
# Function to find the minimum weight  
# Hamiltonian Cycle 
def tsp(graph, v, currPos, n, count, cost): 
  
    # If last node is reached and it has  
    # a link to the starting node i.e  
    # the source then keep the minimum  
    # value out of the total cost of  
    # traversal and "ans" 
    # Finally return to check for  
    # more possible values 
    if (count == n and graph[currPos][0]): 
        answer.append(cost + graph[currPos][0]) 
        return
  
    # BACKTRACKING STEP 
    # Loop to traverse the adjacency list 
    # of currPos node and increasing the count 
    # by 1 and cost by graph[currPos][i] value 
    for i in range(n): 
        if (v[i] == False and graph[currPos][i]): 
              
            # Mark as visited 
            v[i] = True
            tsp(graph, v, i, n, count + 1,  
                cost + graph[currPos][i]) 
              
            # Mark ith node as unvisited 
            v[i] = False
  
# Driver code 
  
# n is the number of nodes i.e. V 
if __name__ == '__main__': 
    n = 4
    graph= [[ 0, 10, 15, 20 ], 
            [ 10, 0, 35, 25 ], 
            [ 15, 35, 0, 30 ], 
            [ 20, 25, 30, 0 ]] 
  
    # Boolean array to check if a node 
    # has been visited or not 
    v = [False for i in range(n)] 
      
    # Mark 0th node as visited 
    v[0] = True
  
    # Find the minimum weight Hamiltonian Cycle 
    tsp(graph, v, 0, n, 1, 0) 
  
    # ans is the minimum weight Hamiltonian Cycle 
    print(min(answer)) 
    ```

