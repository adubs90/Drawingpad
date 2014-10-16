package drawingPad;



import java.awt.*; 



public class EraserTool implements Tool 

{

	public void mousePressed(Point p, ScribbleCanvas canvas)

	{

		canvas.mouseButtonDown = true;

		canvas.x = p.x; 

		canvas.y = p.y; 

		offscreen = canvas.getOffScreenGraphics(); 

		offscreen.setColor(Color.white); 

	}



	public void mouseDragged(Point p, ScribbleCanvas canvas)

	{

		if (canvas.mouseButtonDown)

		{

			int x0, y0, dx, dy; 

			x0 = Math.min(canvas.x, p.x) - 2;

			y0 = Math.min(canvas.y, p.y) - 2;

			dx = Math.abs(p.x - canvas.x) +  5;

			dy = Math.abs(p.y - canvas.y) +  5;

			offscreen.fillRect(x0, y0, dx, dy); 

			canvas.repaint(x0, y0, dx, dy); 

			canvas.x = p.x; 

			canvas.y = p.y; 

		} 

	}



	public void mouseReleased(Point p, ScribbleCanvas canvas)

	{

		canvas.mouseButtonDown = false; 

		canvas.setPenColor(canvas.penColor); 

	}

  

	Graphics offscreen; 

}
