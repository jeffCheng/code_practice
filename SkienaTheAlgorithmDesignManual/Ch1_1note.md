
## 1.2 Selecting the Right Jobs

Problem: Movie Scheduling Problem
Input: A set I of n intervals on the line.
Output: What is the largest subset of mutually non-overlapping intervals which can
be selected from I?

One is based on the notion
that it is best to work whenever work is available. This implies that you should
start with the job with the earliest start date

EarliestJobFirst(I)
    Accept the earlest starting job j from I which does not overlap any
    previously accepted job, and repeat until no more such jobs remain

Maximizing the number
of jobs we do in a given period is clearly connected to banging them out as quickly
as possible. This yields the heuristic:

ShortestJobFirst(I):
    While(I /= Empty) do
        Accept the shortest possible job j from I.
        Delete j, and any interval which intersects j from I.

At this point, an algorithm where we try all possibilities may start to look good,
because we can be certain it is correct. If we ignore the details of testing whether
a set of intervals are in fact disjoint, it looks something like this:

ExhaustiveScheduling(I):
    j=0
    Smax = Empty
    For each of the 2^n subsets Si of intervals I
        If(Si is mutally non-overlapping) and (size(Si)>j)
            then j = size(Si) and Smax = Si.
    Return Smax

OptimalScheduling(I)
    While (I /= ∅) do
        Accept the job j from I with the earliest completion date.
        Delete j, and any interval which intersects j from I.