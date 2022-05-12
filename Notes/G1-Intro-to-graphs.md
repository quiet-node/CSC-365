
# Graphs

## Introduction to Graph

- **Nodes** (also known as Vertices, or just Records or Objects) may have properties (attributes). They are often the contents of data stores, as covered so far in course.

- **Edges** (also known as links, or in some cases just pointers) connect a source Node to a destination Node. Edges represent relations (two-argument predicates). For example if Nodes represent Airports, edge A->B could represent flight(A,B) -- a flight from A to B.



## Graph Traversal

### Depth-first search 
![image](https://user-images.githubusercontent.com/66233296/164994298-8a45cd41-7432-4894-b810-2570f9083e8a.png)

- Using LIFO stack based datastructure
- Each time a node is visited, push that node to the stack until exausht that path. 
- Now backtracking involving poping the node off from the stack (LIFO) to see if that node still has other unvisited node



### Breadth-first search
![image](https://user-images.githubusercontent.com/66233296/164994498-f3a87256-5e65-439d-9084-262173a06d5d.png)

- Using FIFO queue based datastructure (layer by layer algorithm)
- First visit the root node and push it into a queue, then visit all the adjacent nodes of that node and queuing all of them
- Until no more adjacent nodes left, now dequeue the first node and consider if the first node of the queue has any unvisited adjacent nodes, visit and queue them
- Keep repeating the process until the whole graph is traversed

