package drawingPad;



import java.awt.*; 



public class ScribbleTool implements Tool

{

	public void mousePressed(Point p, ScribbleCanvas canvas)

	{

		canvas.mouseButtonDown = true;

		canvas.x = p.x; 

		canvas.y = p.y; 

	}



	public void mouseDragged(Point p, ScribbleCanvas canvas)

	{

		if (canvas.mouseButtonDown)

		{

			int x0, y0, dx, dy; 

			x0 = Math.min(canvas.x, p.x);

			y0 = Math.min(canvas.y, p.y);

			dx = Math.abs(p.x - canvas.x) + 1;

			dy = Math.abs(p.y - canvas.y) + 1;

			canvas.getOffScreenGraphics().drawLine(canvas.x, canvas.y, p.x, p.y); 

			canvas.repaint(x0, y0, dx, dy); 

			canvas.x = p.x; 

			canvas.y = p.y; 

		} 

	}



	public void mouseReleased(Point p, ScribbleCanvas canvas)

	{

		canvas.mouseButtonDown = false; 

	}

}
