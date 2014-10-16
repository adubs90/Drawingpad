package drawingPad;



import java.awt.*;

import java.awt.event.*;

import java.util.EventListener;



public class ToolListener extends ScribbleCanvasListener

{

	protected DrawingPad drawingPad; 

	

	public ToolListener(DrawingPad drawingPad, ScribbleCanvas canvas)

	{

		super(canvas); 

		this.drawingPad = drawingPad;

	}



	public void mousePressed(MouseEvent e)

	{

		Tool tool = drawingPad.getCurrentTool(); 

		if (tool != null)

		{

			tool.mousePressed(e.getPoint(), canvas); 

		}    

	}  

  

	public void mouseReleased(MouseEvent e)

	{

		Tool tool = drawingPad.getCurrentTool(); 

		if (tool != null)

		{

			tool.mouseReleased(e.getPoint(), canvas); 

		}

	}

  

	public void mouseDragged(MouseEvent e)

	{

		Tool tool = drawingPad.getCurrentTool(); 

		if (tool != null)

		{

			tool.mouseDragged(e.getPoint(), canvas); 

		}

	}

}

