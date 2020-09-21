/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George
 */
import java.util.*;
import javafx.util.Pair;
public class GraphGeorge {
    int numberOfNodes;
    ArrayList<Edge>Edges;
    Node nodes[];
    HashSet< Pair<Node, Node> > Found;
    public GraphGeorge(int numberOfNodes) 
    {
        Node.resetNumberOfNodes();
        this.numberOfNodes = numberOfNodes;
        Edges = new ArrayList<>();
        nodes = new Node[numberOfNodes];
        Found = new HashSet<>();
        for(int i = 0;i < numberOfNodes;i++)
            nodes[i] = new Node();
    }
    void AddEdge(Node From, Node To,int Weight)
    {
        this.Edges.add(new Edge(From, To,Weight));
        Found.add(new Pair<>(From, To));
    }
    boolean Check(Pair<Node, Node> Connection)
    {
        return !(Found.contains(Connection));
    }
}
