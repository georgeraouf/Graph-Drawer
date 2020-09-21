import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javafx.util.Pair;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author markn
 */
public class Graph
{
    private final int numberOfNodes;
    private ArrayList<Pair<Integer, Integer>> edgesList = new ArrayList<>();
    private final ArrayList<Point>nodesPositionsList = new ArrayList<>();
    private boolean directedGraph=false;
    private final PanelTools panelTools;
    private final Graphics2D graphics2D;
    Graph(int numberOfNodes, ArrayList<Pair<Integer, Integer>> edgesList, boolean directedGraph, JPanel jpanel)
    {
        graphics2D = (Graphics2D)jpanel.getGraphics();
        this.numberOfNodes=numberOfNodes;
        this.edgesList=edgesList;
        this.directedGraph=directedGraph;
        panelTools = new PanelTools(numberOfNodes, jpanel);
        nodesPositionsList.add(new Point(-1000, -1000)); //To make it 1-Based
    }
    private void InitializeNodesPosition() 
    {
        for (int i=1 ; i<=numberOfNodes ; i++)
        {
            Point newPoint = new Point(panelTools.generateNewPointPosition());
            int x=newPoint.x, y=newPoint.y;
            nodesPositionsList.add(newPoint);
        }
    }
    private void DrawLines()
    {
        for (int i=0 ; i<edgesList.size() ; i++)
        {
            Point fromPoint = new Point(nodesPositionsList.get(edgesList.get(i).getKey()).x, nodesPositionsList.get(edgesList.get(i).getKey()).y);
            Point toPoint = new Point(nodesPositionsList.get(edgesList.get(i).getValue()).x, nodesPositionsList.get(edgesList.get(i).getValue()).y);
            graphics2D.drawLine(fromPoint.x, fromPoint.y, toPoint.x, toPoint.y);
            if (directedGraph)
                DrawArrow(fromPoint, toPoint);
        }
    }
    private void DrawArrow(Point fromPoint, Point toPoint) 
    {
        Point midPoint = new Point((fromPoint.x+toPoint.x)/2, (fromPoint.y+toPoint.y)/2);
        double rotate = Math.atan2(toPoint.y - fromPoint.y, toPoint.x - fromPoint.x);
        AffineTransform transform = new AffineTransform();
        transform.translate(midPoint.x, midPoint.y);
        transform.rotate(rotate);
        graphics2D.fill(transform.createTransformedShape(panelTools.getArrowPolygon()));
    }
    private void DrawNodes()
    {
        for (int i=1 ; i<=numberOfNodes ; i++)
        {
            int xPosition=nodesPositionsList.get(i).x;
            int yPosition=nodesPositionsList.get(i).y;
            graphics2D.setColor(Color.WHITE);
            graphics2D.fillOval(xPosition-25, yPosition-25, 50, 50);
            
            graphics2D.setColor(Color.BLACK);
            graphics2D.drawOval(xPosition-25, yPosition-25, 50, 50);
            String nodeNum=String.valueOf(i);
            graphics2D.drawString(nodeNum, xPosition-(nodeNum.length()==1?3:6), yPosition+3);
        }
    }
    public void DrawGraph()
    {
        InitializeNodesPosition();
        DrawLines();
        DrawNodes();
    }
}
