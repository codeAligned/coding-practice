package general.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import helpers.java.Graph;
import helpers.java.Inputs;
import helpers.java.Node;

class BFS
{
    private static Integer[] traverseBFS(HashMap<Integer, Node<Integer>> graph, Integer startNode)
    {
        ArrayList<Integer> vertices = new ArrayList<Integer>();
        HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        ArrayList<Integer> task = new ArrayList<Integer>();
        task.add(startNode);

        while(task.size() > 0)
        {
            Integer current = task.remove(0);

            if(visited.get(current) == null)
            {
                vertices.add(current);
                visited.put(current, true);

                Node<Integer> currentNbr = graph.get(current);
                while(currentNbr != null)
                {
                    if(visited.get(currentNbr.data) == null)
                    {
                        task.add(currentNbr.data);
                    }

                    currentNbr = currentNbr.next;
                }
            }
        }

        return vertices.toArray(new Integer[vertices.size()]);
    }

    public static void main(String[] args)
    {
        Graph<Integer> graphds = new Graph<Integer>();

        String[] lines = Inputs.readAllInputs();
        Integer[][] adj = new Integer[lines.length][2];

        int count = 0;
        for(String line : lines)
        {
            Integer[] data = Inputs.createArrayOfIntegers(line);
            adj[count] = data;
            count += 1;
        }

        HashMap<Integer, Node<Integer>> graph = graphds.createFromArray(adj);
        graphds.printGraph(graph);

        Integer[] vertices = traverseBFS(graph, adj[0][0]);
        System.out.println("List of vertices are: ");
        for(int vertex : vertices)
        {
            System.out.print(vertex + ", ");
        }
    }
}
