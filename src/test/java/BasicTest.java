import bogdangud.shortestpath.model.Digraph;
import bogdangud.shortestpath.model.DirectedEdge;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicTest {
    @Test
    public void test() {
        Digraph graph = new Digraph();
        graph.addEdge(new DirectedEdge(1, 2, 3));
        graph.addEdge(new DirectedEdge(1, 4, 2));
        graph.addEdge(new DirectedEdge(1, 3, 4));
        graph.addEdge(new DirectedEdge(2, 6, 3));
        graph.addEdge(new DirectedEdge(3, 6, 6));
        graph.addEdge(new DirectedEdge(4, 5, 5));
        graph.addEdge(new DirectedEdge(4, 6, 2));
        graph.addEdge(new DirectedEdge(5, 7, 6));
        graph.addEdge(new DirectedEdge(5, 9, 12));
        graph.addEdge(new DirectedEdge(6, 5, 1));
        graph.addEdge(new DirectedEdge(6, 8, 7));
        graph.addEdge(new DirectedEdge(7, 10, 4));
        graph.addEdge(new DirectedEdge(8, 10, 3));
        graph.addEdge(new DirectedEdge(9, 8, 6));
        graph.addEdge(new DirectedEdge(9, 10, 11));
        graph.addEdge(new DirectedEdge(2, 6, 3));
        DijkstraPathFinder finder = new DijkstraPathFinder(graph);

        Assert.assertArrayEquals(new Integer[]{1, 4, 6, 8}, finder.shortestPath(1, 8));
        Assert.assertArrayEquals(new Integer[]{1, 4, 6, 5}, finder.shortestPath(1, 5));
        Assert.assertArrayEquals(new Integer[]{1, 4, 6, 5, 7}, finder.shortestPath(1, 7));
        Assert.assertArrayEquals(new Integer[]{3, 6, 8, 10}, finder.shortestPath(3, 10));
        Assert.assertArrayEquals(new Integer[]{4, 6, 5, 9}, finder.shortestPath(4, 9));
        Assert.assertArrayEquals(new Integer[]{1, 4, 6, 8, 10}, finder.shortestPath(1, 10));


    }
}
