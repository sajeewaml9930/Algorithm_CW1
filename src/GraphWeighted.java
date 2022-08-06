import java.util.*;

public class GraphWeighted {
    NodeWeighted stationA1;
    NodeWeighted stationB1;

    private final static Scanner inputReader = new Scanner(System.in);

    private Set<NodeWeighted> nodes;
    private boolean directed;

    GraphWeighted(boolean directed) {
        this.directed = directed;
        nodes = new HashSet<>();
    }

    public void addNode(NodeWeighted... n) {
        // We're using a var arg method, so we don't have to call
        // addNode repeatedly
        nodes.addAll(Arrays.asList(n));
    }
    public void addEdge(NodeWeighted source, NodeWeighted destination, double weight) {
        // Since we're using a Set, it will only add the nodes
        // if they don't already exist in our graph
        nodes.add(source);
        nodes.add(destination);

        // We're using addEdgeHelper to make sure we don't have duplicate edges
        addEdgeHelper(source, destination, weight);

        if (!directed && source != destination) {
            addEdgeHelper(destination, source, weight);
        }
    }

    private void addEdgeHelper(NodeWeighted a, NodeWeighted b, double weight) {
        // Go through all the edges and see whether that edge has
        // already been added
        for (EdgeWeighted edge : a.edges) {
            if (edge.source == a && edge.destination == b) {
                // Update the value in case it's a different one now
                edge.weight = weight;
                return;
            }
        }
        // If it hasn't been added already (we haven't returned
        // from the for loop), add the edge
        a.edges.add(new EdgeWeighted(a, b, weight));
    }
    public void printEdges() {
        for (NodeWeighted node : nodes) {
            LinkedList<EdgeWeighted> edges = node.edges;

            if (edges.isEmpty()) {
                System.out.println( node.name + " has no Way.");
                continue;
            }
            System.out.print( node.name + " to ");

            for (EdgeWeighted edge : edges) {
                System.out.print(edge.destination.name + " - " + edge.weight + " minutes ");
            }
            System.out.println();
        }
    }
    public boolean hasEdge(NodeWeighted source, NodeWeighted destination) {
        LinkedList<EdgeWeighted> edges = source.edges;
        for (EdgeWeighted edge : edges) {
            // Again relying on the fact that all classes share the
            // exact same NodeWeighted object
            if (edge.destination == destination) {
                return true;
            }
        }
        return false;
    }
    // Necessary call if we want to run the algorithm multiple times
    public void resetNodesVisited() {
        for (NodeWeighted node : nodes) {
            node.unvisit();
        }
    }
    public void Search(String stationA, String stationB){
        boolean NaTA = false;
        boolean NaTB = false;

        for (NodeWeighted node : nodes){
            if (stationA.equals(node.name)){
                stationA1 = node;
                NaTA = true;
               //System.out.println(stationA1);
            }}
        for (NodeWeighted node : nodes) {
            if (stationB.equals(node.name)) {
                stationB1 = node;
                NaTB = true;
                //System.out.println(stationB1);
                if (NaTA == true && NaTB == true) {
                    DijkstraShortestPath(stationA1, stationB1);
                }
            }
        }
        if(NaTA==false && NaTB==true){
            System.out.println("\nInvalid input\nTry Again\nEnter your correct Station");
        }
        else if(NaTB==false && NaTA==true){
            System.out.println("\nInvalid input\nTry Again\nEnter the exact station you want to go to\n");
        }
        else if (NaTA==false && NaTB==false){
            System.out.println("\nBoth are invalid input\nTry Again\nEnter your correct Station and exact station you want to go to\n");
        }
    }
    public void DijkstraShortestPath(NodeWeighted start, NodeWeighted end) {
        // We keep track of which path gives us the shortest path for each node
        // by keeping track how we arrived at a particular node, we effectively
        // keep a "pointer" to the parent node of each node, and we follow that
        // path to the start
        HashMap<NodeWeighted, NodeWeighted> changedAt = new HashMap<>();
        changedAt.put(start, null);

        // Keeps track of the shortest path we've found so far for every node
        HashMap<NodeWeighted, Double> shortestPathMap = new HashMap<>();

        // Setting every node's shortest path weight to positive infinity to start
        // except the starting node, whose shortest path weight is 0
        for (NodeWeighted node : nodes) {
            if (node == start)
                shortestPathMap.put(start, 0.00);
            else shortestPathMap.put(node, Double.POSITIVE_INFINITY);
        }

        // Now we go through all the nodes we can go to from the starting node
        // (this keeps the loop a bit simpler)
        for (EdgeWeighted edge : start.edges) {
            shortestPathMap.put(edge.destination, edge.weight);
            changedAt.put(edge.destination, start);
        }


        start.visit();

        // This loop runs as long as there is an unvisited node that we can
        // reach from any of the nodes we could till then
        while (true) {
            NodeWeighted currentNode = closestReachableUnvisited(shortestPathMap);
            // If we haven't reached the end node yet, and there isn't another
            // reachable node the path between start and end doesn't exist
            // (they aren't connected)
            if (currentNode == null) {
                System.out.println("There isn't a path between " + start.name + " to " + end.name + ":");
                return;
            }

            // If the closest non-visited node is our destination, we want to print the path
            if (currentNode == end) {
                System.out.println("The path " + start.name + " to " + end.name + ":");

                NodeWeighted child = end;

                // It makes no sense to use StringBuilder, since
                // repeatedly adding to the beginning of the string
                // defeats the purpose of using StringBuilde.


                String path = end.name;

                while (true) {
                    NodeWeighted parent = changedAt.get(child);

                    if (parent == null) {
                        break;
                    }

                    for (EdgeWeighted edge : parent.edges) {
                        if (edge.source == parent && edge.destination == child) {
                            // Update the value in case it's a different one now
                            // Since our changedAt map keeps track of child -> parent relations
                            // in order to print the path we need to add the parent before the child and
                            // it's descendants
                            path =  parent.name +" to " + child.name + " - " + edge.weight  + " minutes" + "\n" + path ;
                            child = parent;
                        }
                    }

                }
                System.out.println(path);
                System.out.println("\nTotal Journey Time: " + shortestPathMap.get(end)+ " minutes");
                System.out.println("\n ");
                return;
            }
            currentNode.visit();

            // Now we go through all the unvisited nodes our current node has an edge to
            // and check whether its shortest path value is better when going through our
            // current node than whatever we had before
            for (EdgeWeighted edge : currentNode.edges) {
                if (edge.destination.isVisited())
                    continue;

                if (shortestPathMap.get(currentNode) + edge.weight < shortestPathMap.get(edge.destination))
                {
                    shortestPathMap.put(edge.destination,shortestPathMap.get(currentNode) + edge.weight);
                    changedAt.put(edge.destination, currentNode);
                }
            }
        }
    }
    private NodeWeighted closestReachableUnvisited(HashMap<NodeWeighted, Double> shortestPathMap) {

        double shortestDistance = Double.POSITIVE_INFINITY;
        NodeWeighted closestReachableNode = null;
        for (NodeWeighted node : nodes) {
            if (node.isVisited())
                continue;

            double currentDistance = shortestPathMap.get(node);
            if (currentDistance == Double.POSITIVE_INFINITY)
                continue;

            if (currentDistance < shortestDistance) {
                shortestDistance = currentDistance;
                closestReachableNode = node;
            }
        }
        return closestReachableNode;
    }

}