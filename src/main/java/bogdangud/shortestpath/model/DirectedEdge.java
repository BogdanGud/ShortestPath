package bogdangud.shortestpath.model;

public class DirectedEdge {
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
