/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author George
 */
import javafx.util.*;
public class Node {
    final int id;
    static int cnt = 1;
    Pair<Double, Double>Pos;
    public Node() {
        id = cnt++;
        Pos = new Pair<Double, Double>(0.0, 0.0);
    }
    public static void resetNumberOfNodes()
    {
        cnt=1;
    }
}
