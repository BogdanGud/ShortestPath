package bogdangud.shortestpath.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Digraph {
    private HashMap<Integer, ArrayList<DirectedEdge>> adjacencyList = new HashMap<>();
    private static final Logger log = Logger.getLogger(Digraph.class);

    private Digraph() {
    }

    private void addEdge(int source, int target, int weight) {
        DirectedEdge newEdge = new DirectedEdge(source, target, weight);

        if (!adjacencyList.containsKey(newEdge.getSource())) {
            adjacencyList.put(newEdge.getSource(), new ArrayList<>());
        }
        ArrayList<DirectedEdge> currentEdges = adjacencyList.get(newEdge.getSource());
        boolean edgeExists = false;
        for (int i = 0; i < currentEdges.size(); i++) {
            if (currentEdges.get(i).getTarget() == newEdge.getTarget()) {
                currentEdges.set(i, newEdge);
                edgeExists = true;
                break;
            }
        }
        if (!edgeExists) {
            currentEdges.add(newEdge);
        }
        log.info("New edge was created from " + source + " to " + target + ", weight = " + weight);
        adjacencyList.put(newEdge.getSource(), currentEdges);
    }


    public static class Builder {
        private Digraph digraph;

        public Builder() {
            log.info("Create new instance of Digraph");
            this.digraph = new Digraph();
        }

        public Builder edge(int source, int target, int weight) {
            this.digraph.addEdge(source, target, weight);
            return this;
        }

        public Digraph build() {
            return this.digraph;
        }
    }

    public ArrayList<DirectedEdge> edgesOf(int node) {
        return adjacencyList.get(node);
    }

    public ArrayList<DirectedEdge> getEdges() {
        ArrayList list = new ArrayList<DirectedEdge>();
        for (int source : adjacencyList.keySet()) {
            ArrayList<DirectedEdge> currentEdges = adjacencyList.get(source);
            for (DirectedEdge e : currentEdges) {
                list.add(e);
            }
        }
        return list;
    }

    public Iterable<Integer> getVertices() {
        HashSet set = new HashSet();
        for (DirectedEdge edge : getEdges()) {
            set.add(edge.getSource());
            set.add(edge.getTarget());
        }
        return set;
    }

    public String toString() {
        String out = "";
        for (int from : adjacencyList.keySet()) {
            ArrayList<DirectedEdge> currentEdges = adjacencyList.get(from);
            out += from + " -> ";

            if (currentEdges.size() == 0)
                out += "-,";

            for (DirectedEdge edge : currentEdges)
                out += edge.getTarget() + " @ " + edge.getWeight() + ", ";
            out += "\n";
        }
        return out;
    }

    public int size() {
        return adjacencyList.size();
    }

}
