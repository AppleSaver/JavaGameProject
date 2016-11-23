package test;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class Board extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int width = 700;
	public static int height = 700;
   
    public static void main(String[] args){
        new Board();
    }

    public Board(){
       this.setTitle("Mücahid AKYAR");
       this.setSize(width, height);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       GameBoard gameB = new GameBoard();
       this.add(gameB, BorderLayout.CENTER);

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
		public void run(){
			theBoard.repaint();
		}
	}
	
	@SuppressWarnings("serial")
	class GameBoard extends JComponent {
		Random rnd=new Random();
        
		public ArrayList<Ball> balls = new ArrayList<Ball>();
		
		public GameBoard(){
			for(int i=0; i< 20; i++){
		        int randomX = (int) (Math.random() * (Board.width - 30) + 1);
		           
		        int randomY = (int) (Math.random() * (Board.height - 30) + 1);
		           
				balls.add(new Ball(randomX, randomY));
			}
		}
		
		@Override
		public void paint(Graphics g){
			
			 Graphics2D g2d = (Graphics2D)g;
	
			 g2d.setColor(Color.BLACK);
			
			 g2d.fillRect(0, 0, getWidth(), getHeight());
	
			 g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			 
			 
			 float alpha = 1.0f;
			 
			 Color color=new Color(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
			 
			 int type = AlphaComposite.SRC_OVER; 

			 AlphaComposite composite = AlphaComposite.getInstance(type, alpha);
			 g2d.setColor(color);
			 
			 
			 for(Ball ball : balls){

				 ball.move();
				 
				 g2d.draw(ball.getEllipse());
				 
			 }

			
		}

	}
