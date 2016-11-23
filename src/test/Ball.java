package test;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;



// add some comment
public class Ball extends Ellipse2D {
	int width = Board.width;
	int height = Board.height;
	int xDirection=1;
	int yDirection=1;
	int uLeftXCor, uLeftYCor;
	public static int diameter = 30;
	private Ellipse2D ellipse = new Ellipse2D.Double(uLeftXCor, uLeftYCor, diameter, diameter);
	
	public Ball(int RandomX, int RandomY){
		super();
		this.uLeftXCor = RandomX;
		this.uLeftYCor = RandomY;
		ellipse = new Ellipse2D.Double(uLeftXCor, uLeftYCor, diameter, diameter);
	}
	public void move() {
        if (uLeftXCor + xDirection < 0)
            xDirection = 1;
        if (uLeftXCor + xDirection > width - diameter-20)
            xDirection = -1;
        if (uLeftYCor + yDirection < 0)
            yDirection = 1;
        if (uLeftYCor + yDirection > height - diameter-40)
            yDirection = -1;
        
        uLeftXCor = uLeftXCor + xDirection;
        uLeftYCor = uLeftYCor + yDirection;
        
        ellipse = new Ellipse2D.Double(uLeftXCor, uLeftYCor, diameter, diameter);
       
	}
	
	public Ellipse2D getEllipse() {
        return ellipse;
    }
	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Rectangle2D getBounds2D() {
		return new Rectangle(uLeftXCor, uLeftYCor, diameter, diameter);
	}
	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setFrame(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		
	}
	
}