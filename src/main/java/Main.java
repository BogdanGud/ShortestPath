import bogdangud.shortestpath.model.Digraph;
import bogdangud.shortestpath.model.DirectedEdge;

public class Main {
    public static void main(String[] args) {
//        Graph graph = new Graph.Builder().setEdge(1,2,3).setEdge(1,4,2).setEdge(1,3,4).setEdge(2,6,3).setEdge(3,6,6)
//                .setEdge(4,5,5).setEdge(4,6,2).setEdge(5,7,6).setEdge(5,9,12).setEdge(6,5,1).setEdge(6,8,7).setEdge(7,10,4)
//                .setEdge(8,10,3).setEdge(9,8,6).setEdge(9,10,11).build();

        Digraph graph = new Digraph();
        graph.addEdge(new DirectedEdge(1,2,3));
        graph.addEdge(new DirectedEdge(1,4,2));
        graph.addEdge(new DirectedEdge(1,3,4));
        graph.addEdge(new DirectedEdge(2,6,3));
        graph.addEdge(new DirectedEdge(3,6,6));
        graph.addEdge(new DirectedEdge(4,5,5));
        graph.addEdge(new DirectedEdge(4,6,2));
        graph.addEdge(new DirectedEdge(5,7,6));
        graph.addEdge(new DirectedEdge(5,9,12));
        graph.addEdge(new DirectedEdge(6,5,1));
        graph.addEdge(new DirectedEdge(6,8,7));
        graph.addEdge(new DirectedEdge(7,10,4));
        graph.addEdge(new DirectedEdge(8,10,3));
        graph.addEdge(new DirectedEdge(9,8,6));
        graph.addEdge(new DirectedEdge(9,10,11));
        graph.addEdge(new DirectedEdge(2,6,3));

       // System.out.println(graph);

        DijkstraPathFinder finder = new DijkstraPathFinder(graph);
        System.out.println(finder.shortestPath(1,8));
        System.out.println(finder.shortestPath(2,7));
    }
}
