import bogdangud.shortestpath.model.Digraph;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class BasicTest {
    @Test
    @Ignore
    public void test() {
        Digraph graph = new Digraph.Builder().edge(1,2,3).edge(1,4,2).edge(1,3,4).edge(2,6,3).edge(3,6,6)
                .edge(4,5,5).edge(4,6,2).edge(5,7,6).edge(5,9,12).edge(6,5,1).edge(6,8,7).edge(7,10,4)
                .edge(8,10,3).edge(9,8,6).edge(9,10,11).build();
        DijkstraPathFinder finder = new DijkstraPathFinder(graph);

        Assert.assertArrayEquals(new Integer[]{1, 4, 6, 8}, finder.shortestPath(1, 8));
        Assert.assertArrayEquals(new Integer[]{1, 4, 6, 5}, finder.shortestPath(1, 5));
        Assert.assertArrayEquals(new Integer[]{1, 4, 6, 5, 7}, finder.shortestPath(1, 7));
        Assert.assertArrayEquals(new Integer[]{3, 6, 8, 10}, finder.shortestPath(3, 10));
        Assert.assertArrayEquals(new Integer[]{4, 6, 5, 9}, finder.shortestPath(4, 9));
        Assert.assertArrayEquals(new Integer[]{1, 4, 6, 8, 10}, finder.shortestPath(1, 10));


    }
}
