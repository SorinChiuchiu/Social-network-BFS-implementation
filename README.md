**Challenge**

**Let's build a social network.**

**In this social network, each user has friends.**

**A chain of friends between two users, user A and user B, is a sequence of users starting with A and ending with B, such that for each user in the chain, ua, the subsequent user, ua + 1, are friends.**

**Given a social network and two users, user A and user B, please write a function that computes the length of the shortest chain of friends between A and B.**

Discussion

I chose to represent this social network as a graph. The reason behind this is that a graph is a very effective way of representing connections between objects, nodes, in this case a node representing a person/friend.

I used the BFS (Breadth First Search) algorithm. I did consider algorithms like Dijkstra and A\*, but I opted for the BFS because in this case, to find the shortest chain of friends between A and B, we use an undirected graph with no weights, so using Dijkstra would have been slower and although A\* could be faster, the level of complexity would be way harder. I used BFS instead of DFS (Depth First Search) because the latter is not guaranteed to return the shortest chain.

I considered 5 test cases:

- 2 in which I verified if the adjacency matrix used to initialize the graph (social network) is valid, taking into consideration that a node cannot be isolated and a node cannot have a cycle to itself (a person cannot befriend itself)
- 5 in which I verified the correctness BFS:

  - In the truth test, if the start node is invalid – it will return false
  - In the distance calculation test, if the start node is invalid – it will return -1
  - If the target node is out of range – it will return false and print the BFS traversal of the graph instead
  - In the truth test, if both start and target nodes are correct – it will return true and print the distance between the nodes
  - In the distance calculation test, if both start and target nodes are correct – computing the distance for the given matrix between node 0 and 5 it will return 3.

I've chosen to do these tests so that I could verify both the problem hypothesis and the correctness of the algorithm even when the input data is not valid. By realizing these tests, I could minimize the risk of an unexpected error and verify if the program returns the expected results.
