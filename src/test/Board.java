package test;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class Board extends JFrame{
	

	public static int boardWidth = 600;
	public static int boardHeight = 600;
	
	public static void main(String[] args){
		new Board();
	}
	public Board() {
		
		this.setSize(boardWidth, boardHeight);
		this.setTitle("Ball");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameBoard gb = new GameBoard();
		
		this.add(gb, BorderLayout.CENTER);
		
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
	     
		executor.scheduleAtFixedRate(new RepaintTheBoard(this), 0L, 20L, TimeUnit.MILLISECONDS); 
	
		this.setVisible(true);
	}

}

class RepaintTheBoard implements Runnable{

	Board theBoard;
	
	public RepaintTheBoard(Board theBoard){
		this.theBoard = theBoard;
	}

	@Override
	public void run() {
		
		// Redraws the game board
		
		theBoard.repaint();
		
	}
	
}

@SuppressWarnings("serial")

//GameDrawingPanel is what we are drawing on

class GameBoard extends JComponent {
    Random rnd = new Random();
    public ArrayList<Ball> balls = new ArrayList<Ball>();
    int width = Board.boardWidth;
    int height = Board.boardHeight;

    public GameBoard() {
        for (int i = 0; i < 5; i++) {
            int randomStartXPos = (int) (Math.random() * (width - 30) + 1);
            int randomStartYPos = (int) (Math.random() * (height - 30) + 1);
            balls.add(new Ball(randomStartXPos, randomStartYPos));
           
           Ball.balls = balls;
        }
    }

    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform identity = new AffineTransform();

        
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setPaint(new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255)));
        
        for (Ball ball : balls) {
             ball.move();
            g2d.draw(ball.getEllipse());
           
        }
    }
    @Override
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		drawLine(g2d);
    }
    
    private void drawLine(Graphics2D g){
		Graphics2D g2d = (Graphics2D) g;

		float[] dash1 = {1f,0f, 4f};
    	float[] dash2 = {1f,0f, 4f};
    	float[] dash3 = {1f,0f, 4f};
    	float[] dash4 = {1f,0f, 4f};
    	
    	
    	BasicStroke bs1 = new BasicStroke(2, BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND, 1.0f, dash1,2f);
    	g2d.setStroke(bs1);
    	g2d.setColor(Color.RED);
    	g2d.drawLine(10, 10, getWidth()-10, 10);
    	
    	BasicStroke bs2 = new BasicStroke(2, BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND, 1.0f, dash2,2f);
    	g2d.setStroke(bs2);
    	g2d.setColor(Color.GREEN);
    	g2d.drawLine(10,10, 10, getHeight()-10);
    	
    	BasicStroke bs3 = new BasicStroke(2, BasicStroke.CAP_SQUARE,BasicStroke.JOIN_ROUND, 1.0f, dash3,2f);
    	g2d.setColor(Color.BLUE);
    	g2d.setStroke(bs3);
    	g2d.drawLine(10, getHeight()-10, getWidth()-10, getHeight()-10);
    	
    	BasicStroke bs4 = new BasicStroke(2, BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND, 1.0f, dash4,2f);
    	g2d.setColor(Color.MAGENTA);
    	g2d.setStroke(bs4);
    	g2d.drawLine(getWidth()-10, getHeight()-10, getWidth()-10, 10);
	}

}


