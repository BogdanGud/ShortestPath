import bogdangud.shortestpath.model.Digraph;
import bogdangud.shortestpath.model.DirectedEdge;

import java.util.*;

public class DijkstraPathFinder {
    private int size;
    private Digraph graph;
    private HashMap<Integer, Integer> weightStore;
    private HashMap<Integer, Integer> prevNode;
    private PriorityQueue<Integer> priorityQueue;


    public DijkstraPathFinder(Digraph graph) {
        this.graph = graph;
        this.size = graph.size();
    }

    public Integer[] shortestPath(int NodeA, int NodeB) {
        prevNode = new HashMap<Integer, Integer>();
        weightStore = new HashMap<Integer, Integer>();
        priorityQueue = new PriorityQueue<>(size, pqComparator);

        for (int node : graph.getVertices()) {
            weightStore.put(node, Integer.MAX_VALUE);
        }

        prevNode.put(NodeA, -1);  // set negative value to previous vertex
        weightStore.put(NodeA, 0);  //set weight value to be 0
        priorityQueue.add(NodeA);  // set first Node to queue

        while (priorityQueue.size() > 0) {
            int currentNode = priorityQueue.poll();
            ArrayList<DirectedEdge> nearByNodes = graph.edgesOf(currentNode);

            if (nearByNodes == null) continue;

            for (DirectedEdge nearByNode : nearByNodes) {
                int nextNode = nearByNode.getTarget();

                int newDistance = weightStore.get(currentNode) + nearByNode.getWeight();
                if (weightStore.get(nextNode) == Integer.MAX_VALUE) {
                    prevNode.put(nextNode, currentNode);
                    weightStore.put(nextNode, newDistance);
                    priorityQueue.add(nextNode);
                } else {
                    if (weightStore.get(nextNode) > newDistance) {
                        prevNode.put(nextNode, currentNode);
                        weightStore.put(nextNode, newDistance);
                    }
                }

            }
        }

        ArrayList<Integer> nodePath = new ArrayList<>();
        Stack<Integer> temporaryNodePath = new Stack<>();
        temporaryNodePath.push(NodeB);

        int temp = NodeB;
        while (prevNode.get(temp) >= 0 && prevNode.containsKey(temp) && temp >= 0) {
            temp = prevNode.get(temp);
            temporaryNodePath.push(temp);
        }

        while (temporaryNodePath.size() > 0) {
            nodePath.add(temporaryNodePath.pop());
        }
        Integer[] result = nodePath.toArray(new Integer[nodePath.size()]);
        return result;
    }

    public Comparator<Integer> pqComparator = new Comparator<Integer>() {

        public int compare(Integer objectA, Integer objectB) {
            if (weightStore.get(objectA) > weightStore.get(objectB)) {
                return 1;
            } else if (weightStore.get(objectA) < weightStore.get(objectB)) {
                return -1;
            }
            return 0;
        }
    };


}

