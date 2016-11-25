package test;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;



// add some comment
public class Ball extends Ellipse2D {
	int width = Board.boardWidth;
	int height = Board.boardHeight;
	int xDirection=3;
	int yDirection=3;
	int uLeftXCor, uLeftYCor;
	public static int diameter = 30;
	private Ellipse2D ellipse = new Ellipse2D.Double(uLeftXCor, uLeftYCor, diameter, diameter);
	static ArrayList<Ball> balls = new ArrayList<Ball>();
	
	
	public Ball(int RandomX, int RandomY){
		
		this.xDirection = (int) (Math.random() * 4 + 1);
		this.yDirection = (int) (Math.random() * 4 + 1);
		
		this.uLeftXCor = RandomX;
		this.uLeftYCor = RandomY;
		//ellipse = new Ellipse2D.Double(uLeftXCor, uLeftYCor, diameter, diameter);
	}
	public void move() {
		  
		
		        Rectangle2D ballToCheck = this.getBounds2D();
		
		        for(Ball ball : balls){

		            Rectangle2D otherBall = ball.getBounds2D();
		
		            if(ball != this && otherBall.intersects(ballToCheck)){

		                int tempXDirection = this.xDirection;
		
		                int tempYDirection = this.yDirection;

		                this.xDirection = ball.xDirection;
		
		                this.yDirection = ball.yDirection;

		                ball.xDirection = tempXDirection;
		
		                ball.yDirection = tempYDirection;

		            }
		 } // END OF NEW STUFF

        if (uLeftXCor + xDirection < 10)
            xDirection = 3;
        if (uLeftXCor + xDirection > height - diameter-30)
            xDirection = -3;
        if (uLeftYCor + yDirection < 10)
            yDirection = 3;
        if (uLeftYCor + yDirection > width - diameter-50)
            yDirection = -3;
        
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