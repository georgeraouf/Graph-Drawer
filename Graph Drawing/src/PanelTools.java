
import java.awt.Point;
import java.awt.Polygon;
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
public class PanelTools 
{
    private final Polygon arrowPolygon = new Polygon();
    private final double rotationAngle;
    private final Point jframeCenter;
    private Point previousPoint;
    
    PanelTools(int numberOfNodes, JPanel jpanel)
    {
        arrowPolygon.addPoint(-10,10);
        arrowPolygon.addPoint(20,0);
        arrowPolygon.addPoint(-10,-10);
        rotationAngle = Math.toRadians(360/numberOfNodes);
        jframeCenter = new Point(jpanel.getWidth()/2, jpanel.getHeight()/2);
        previousPoint = new Point(jframeCenter.x-300, jframeCenter.y);
    }
    
    public Point generateNewPointPosition()
    {
        Point newPoint = new Point();
        newPoint.x = (int) (jframeCenter.x + (previousPoint.x-jframeCenter.x)*Math.cos(rotationAngle) - (previousPoint.y-jframeCenter.y)*Math.sin(rotationAngle));
        newPoint.y = (int) (jframeCenter.y + (previousPoint.x-jframeCenter.x)*Math.sin(rotationAngle) + (previousPoint.y-jframeCenter.y)*Math.cos(rotationAngle));
        previousPoint = newPoint;
        return newPoint;
    }

    public Polygon getArrowPolygon() {
        return arrowPolygon;
    }
    
}
