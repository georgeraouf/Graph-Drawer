/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George
 */
public class Edge {
    Node From, To;
    int Weight;
    public Edge(Node From, Node To,int Weight) {
        this.From = From;
        this.To = To;
        this.Weight = Weight;
    }
}
