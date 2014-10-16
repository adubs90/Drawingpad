package drawingPad;



import java.awt.*;



public class TwoEndsShapeTool implements Tool

{

    protected int xStart, yStart; 

	protected TwoEndsShape shape;    

	protected Graphics onscreen; 



	public TwoEndsShapeTool(TwoEndsShape shape)

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

		if (shape != null)

		{

			shape.drawOutline(onscreen, xStart, yStart, xStart, yStart); 

		}

	}



	public void mouseDragged(Point p, ScribbleCanvas canvas)

	{

		if (canvas.mouseButtonDown && shape != null)

		{

			shape.drawOutline(onscreen, xStart, yStart, canvas.x, canvas.y);  

			shape.drawOutline(onscreen, xStart, yStart, p.x, p.y);  

			canvas.x = p.x; 

			canvas.y = p.y; 

		} 

	}



	public void mouseReleased(Point p, ScribbleCanvas canvas)

	{

		canvas.mouseButtonDown = false; 

		onscreen.setPaintMode();

		if (shape != null)

		{

			Graphics offscreen = canvas.getOffScreenGraphics(); 

			shape.drawShape(offscreen, xStart, yStart, p.x, p.y);       

			canvas.repaint(); 

		}

	}

} 




