package drawingPad;



import java.awt.*;

import java.awt.event.*;



public class ScribbleCanvasListener implements MouseListener, MouseMotionListener

{

	public ScribbleCanvasListener(ScribbleCanvas canvas)

	{    

		this.canvas = canvas; 

	}



	public void mousePressed(MouseEvent e)

	{

		Point p = e.getPoint(); 

		canvas.mouseButtonDown = true;

		canvas.x = p.x; 

		canvas.y = p.y;       

	} 



	public void mouseReleased(MouseEvent e)

	{

		canvas.mouseButtonDown = false;       

	}    



	public void mouseDragged(MouseEvent e)

	{

		Point p = e.getPoint(); 

		if (canvas.mouseButtonDown)

		{

			canvas.getOffScreenGraphics().drawLine(canvas.x, canvas.y, p.x, p.y); 

			int x0 = Math.min(canvas.x, p.x); 

			int y0 = Math.min(canvas.y, p.y); 

			int dx = Math.abs(p.x - canvas.x) + 1;

			int dy = Math.abs(p.y - canvas.y) + 1; 

			canvas.repaint(x0, y0, dx, dy); 

			canvas.x = p.x; 

			canvas.y = p.y; 

		}       

	}



	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}  

	public void mouseExited(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}     



	protected ScribbleCanvas canvas; 

}
