# Object-Oriented Design
https://leetcode.com/discuss/interview-question/object-oriented-design


## Head First Design Patterns
https://www.youtube.com/watch?v=v9ejT8FO-7I

## General Idea of System Design
- [What are system design questions?](https://www.hiredintech.com/classrooms/system-design/lesson/52)
- Design high level architecture.  The typical outcome of such a discussion is a high-level architecture addressing the *goals* and *constraints* in the question. Perhaps the interviewer will choose one or more areas where they will want to discuss *bottlenecks* and other common problems.
- [Overview](https://www.hiredintech.com/classrooms/system-design/lesson/53) 
   - Problems: Approach questions in a chaotic way and get ratholed, or
   - Problems: Lack solid understanding of how to properly design architectures that scale.
   - *The System Design Process*
   - *Designing Scalable Architectures*
#### Step 1: Constraints and use cases
  - Clarify the `system's constraints` and to identify what `use cases` the system needs to satisfy. 
  - The scope of the system
  - Usually, part of what the interviewer wants to see is if you can gather the requirements about the problem at hand, and design a solution that covers them well. Never assume things that were not explicitly stated.
  - Tiny URL `Constraints` and `User case`
  - 

#### Step 2: Abstract design
  - The goal of this is to `outline` all the important components that your architecture will need.
      - Draw a simple diagram of your ideas(Sketch your main components and the connections between them)
      - Justify your ideas in front of the interviewer and try to address every constraint and use case.
      - You have to make sure you are familiar with what's out there and feel comfortable using this knowledge.
      - 
      
#### Step 3: Understanding bottlenecks
   - Now that you have your high-level design, start thinking about what bottlenecks it has. 
     - Perhaps your system needs a load balancer and many machines behind it to handle the user requests
     - Or maybe the data is so huge that you need to distribute your database on multiple machines.
     - What are some of the downsides that occur from doing that?
     - Is the database too slow and does it need some in-memory caching?
     - 
   - Once you've outlined the core bottlenecks you see, you can start addressing them in the next step.
#### Step 4: Scaling your abstract design
   - Address these bottlenecks by using the fundamentals principles of scalable system design.
   
 ### Scalability:
 https://www.youtube.com/watch?v=-W9F__D3oY4&feature=emb_title
 
 http://ninefu.github.io/blog/Harvard_CS75_Notes/
 #### Fundamentals
 
 
