package drawingPad;



import java.awt.*; 



public class TwoEndsTool implements Tool

{

	public static final int LINE = 0; 

	public static final int OVAL = 1; 

	public static final int RECT = 2; 

	protected int shape = LINE; 

	protected int xStart, yStart; 

	protected Graphics onscreen; 



	public TwoEndsTool(int shape)

	{

		this.shape = shape; 

	}



	public void mousePressed(Point p, ScribbleCanvas canvas)

	{

		canvas.mouseButtonDown = true;

		xStart = canvas.x = p.x; 

		yStart = canvas.y = p.y; 

		onscreen = canvas.getGraphics();

		onscreen.setXORMode(Color.darkGray); 

		onscreen.setColor(Color.lightGray); 

		switch (shape)

		{

			case LINE:

				drawLine(onscreen, xStart, yStart, xStart, yStart); 

				break; 

			case OVAL:

				drawOval(onscreen, xStart, yStart, 1, 1); 

				break; 

			case RECT:

				drawRect(onscreen, xStart, yStart, 1, 1); 

				break; 

		}

	}



	public void mouseDragged(Point p, ScribbleCanvas canvas)

	{

		if (canvas.mouseButtonDown)

		{

			switch (shape)

			{

				case LINE:

					drawLine(onscreen, xStart, yStart, canvas.x, canvas.y); 

					drawLine(onscreen, xStart, yStart, p.x, p.y); 

					break; 

				case OVAL:

					drawOval(onscreen, xStart, yStart, canvas.x - xStart + 1, canvas.y - yStart + 1); 

					drawOval(onscreen, xStart, yStart, p.x - xStart + 1, p.y - yStart + 1);  

					break; 

				case RECT:

					drawRect(onscreen, xStart, yStart, canvas.x - xStart + 1, canvas.y - yStart + 1);  

					drawRect(onscreen, xStart, yStart,  p.x - xStart + 1, p.y - yStart + 1); 

					break; 

			}

			canvas.x = p.x; 

			canvas.y = p.y; 

		} 

	}



	public void mouseReleased(Point p, ScribbleCanvas canvas)

	{

		canvas.mouseButtonDown = false; 

		onscreen.setPaintMode();

		Graphics offscreen = canvas.getOffScreenGraphics(); 

		switch (shape)

		{

			case LINE:

				drawLine(offscreen, xStart, yStart, p.x, p.y); 

				break; 

			case OVAL:

				drawOval(offscreen, xStart, yStart, p.x - xStart + 1, p.y - yStart + 1); 

				break;

			case RECT:

				drawRect(offscreen, xStart, yStart, p.x - xStart + 1, p.y - yStart + 1); 

				break; 

		}

		canvas.repaint(); 

	}



	public static void drawLine(Graphics g, int x1, int y1, int x2, int y2)

	{

		g.drawLine(x1, y1, x2, y2); 

	} 



	public static void drawRect(Graphics g, int x, int y, int w, int h)

	{

		if (w < 0)

		{

			x = x + w; 

			w = -w; 

		}

		if (h < 0)

		{

			y = y + h;

			h = -h;

		}

		g.drawRect(x, y, w, h); 

	}

  

	public static void drawOval(Graphics g, int x, int y, int w, int h)

	{

		if (w < 0)

		{

			x = x + w; 

			w = -w; 

		}

		if (h < 0)

		{

			y = y + h;

			h = -h;

		}

		g.drawOval(x, y, w, h); 

	} 

}
