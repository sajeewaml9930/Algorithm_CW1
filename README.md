<h2>Algorithmic Approach</h2>
Dijkstra's algorithm was used for the find the fastest journey time route between any two stations on the above part of the
TfL systems. Particularly, this should be done by representing the tube network as a graph and using E.W. Dijkstra's Shortest
Path algorithm to find the fastest route between the 2 tube stations.
<h2>The Algorithmic Strategy</h2>
Dijkstra's Algorithm basically starts at the Station A and it analyzes the graph to find the fastest journey between Station B
and all the other nodes in the graph.
<h2>Data Structure</h2>
To find the fastest journey, a Linkedlist is an excellent choice. Because one node reference should be kept in a LinkedList.
The reason why I used it was that we don't have to predefine the size of an LinkedList like in Nodes.
Furthermore, a linked list has been used for the problem because it can store the reference of the next node.
