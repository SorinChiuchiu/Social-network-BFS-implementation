**Challenge**

**Let's build a social network.**

**In this social network, each user has friends.**

**A chain of friends between two users, user A and user B, is a sequence of users starting with A and ending with B, such that for each user in the chain, ua, the subsequent user, ua + 1, are friends.**

**Given a social network and two users, user A and user B, please write a function that computes the length of the shortest chain of friends between A and B.**

Discussion

I chose to represent this social network as a graph. The reason behind this is that a graph is a very effective way of representing connections between objects, nodes, in this case a node representing a person/friend.

I used the BFS (Breadth First Search) algorithm. I did consider algorithms like Dijkstra and A\*, but I opted for the BFS because in this case, to find the shortest chain of friends between A and B, we use an undirected graph with no weights, so using Dijkstra would have been slower and although A\* could be faster, the level of complexity would be way harder. I used BFS instead of DFS (Depth First Search) because the latter is not guaranteed to return the shortest chain.

I considered 9 test cases:

- 2 in which I verified the correctness of the result, using a positive test and a negative one.
- 7 in which I verified the validity of the code by intentionally creating situations in which the custom exceptions are thrown. 
   Tested to make sure that exceptions are thrown and that the exception thrown is the correctly designed one for the situation:
  - Tested if the algorithm throws an exception when a node has cycles
  - Tested if the algorithm throws an exception when a node has no neighbours
  - Tested if the algorithm throws an exception when starting node is invalid
  - Tested if the algorithm throws an exception when target node is invalid
  - Tested if the algorithm throws an exception when starting and target nodes are the same
  - Tested if the algorithm doesn't faulty throws an exception when starting and target nodes are correct
  - Tested if the algorithm doesn't faulty throws an exception for not finding a path between nodes.

I've chosen to do these tests so that I could verify both the problem hypothesis and the correctness of the algorithm even when the input data is not valid. By realizing these tests, I could minimize the risk of an unexpected error and verify if the program returns the expected results.
