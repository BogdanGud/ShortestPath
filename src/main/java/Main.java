import bogdangud.shortestpath.model.Digraph;

public class Main {
    public static void main(String[] args) {
        Digraph graph = new Digraph.Builder().edge(1,2,3).edge(1,4,2).build();

        System.out.println("hi");
        System.out.println(graph);

       // DijkstraPathFinder finder = new DijkstraPathFinder(graph);
       // System.out.println(finder.shortestPath(1,8));
       // System.out.println(finder.shortestPath(2,7));
    }
}
