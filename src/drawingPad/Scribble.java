package drawingPad;



import java.awt.*;

import java.awt.event.*;

import java.util.EventListener;

import javax.swing.*; 



public class Scribble extends JApplet

{

	protected ScribbleCanvas canvas; 

	protected EventListener listener;

	protected boolean isApplet = false;

	

	public Scribble()

	{

		this(true); 

	}



	public Scribble(boolean isApplet)

	{

		this.isApplet = isApplet; 

		getContentPane().setLayout(new BorderLayout()); 

		getContentPane().add(makeCanvas(), BorderLayout.CENTER);

		listener = makeCanvasListener(canvas);     

		canvas.addMouseListener((MouseListener) listener); 

		canvas.addMouseMotionListener((MouseMotionListener) listener); 

	}



	public static void main(String[] args)

	{

		JFrame frame = new JFrame();

		frame.setTitle("Scribble Pad");

		frame.setBackground(Color.lightGray);

		frame.getContentPane().setLayout(new BorderLayout());

		frame.getContentPane().add(new Scribble(false), BorderLayout.CENTER);

		frame.addWindowListener(new AppCloser()); 

		frame.pack();

		frame.setSize(600, 400);

		frame.show();

	}



	protected Component makeCanvas()

	{

		canvas = new ScribbleCanvas(); 

		canvas.setBackground(Color.red); 

		return canvas; 

	}



	protected EventListener makeCanvasListener(ScribbleCanvas canvas)

	{

		return new ScribbleCanvasListener(canvas); 

	}



	static class AppCloser extends WindowAdapter

	{

		public void windowClosing(WindowEvent e)

		{

			System.exit(0);

		}

	} 

}




