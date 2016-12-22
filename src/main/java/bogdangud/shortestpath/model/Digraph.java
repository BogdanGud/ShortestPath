package bogdangud.shortestpath.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Digraph {
    private HashMap<Integer, ArrayList<DirectedEdge>> adjacencyList = new HashMap<>();
    private static final Logger log = Logger.getLogger(Digraph.class);

    private Digraph(Builder builder) {
        adjacencyList = builder.adjacencyList;
    }

    public static class Builder {
        private HashMap<Integer, ArrayList<DirectedEdge>> adjacencyList = new HashMap<>();

        public Builder edge ( int source, int target, int weight) {
            DirectedEdge tempEdge = new DirectedEdge(source, target, weight);
            addEdge(tempEdge);
            return this;
        }

        private void addEdge(DirectedEdge newEdge) {
            if (!adjacencyList.containsKey(newEdge.getSource())){
                adjacencyList.put(newEdge.getSource(), new ArrayList<DirectedEdge>());
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

            if (!edgeExists)
                currentEdges.add(newEdge);
            log.info("The edge was created.");

            adjacencyList.put(newEdge.getSource(), currentEdges);
        }

        public Digraph build() {
            return new Digraph(this);
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

    public static class DirectedEdge {
        private final int source;
        private final int target;
        private final int weight;

        public DirectedEdge(int source, int target, int weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }

        public int getSource() {
            return source;
        }

        public int getTarget() {
            return target;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "DirectedEdge{" +
                    "source=" + source +
                    ", target=" + target +
                    ", weight=" + weight +
                    '}';
        }
    }
}
