package drawingPad;



import java.awt.*;

import java.awt.event.*;

import java.util.EventListener;



public class KeyToolListener extends ToolListener implements KeyListener

{ 

	public KeyToolListener(DrawingPad drawingPad, ScribbleCanvas canvas)

	{

		super(drawingPad, canvas); 

	}



	public void keyPressed(KeyEvent e)

	{

		Tool tool = drawingPad.getCurrentTool(); 

		if (tool != null && tool instanceof KeyEventTool)

		{

			KeyEventTool keyTool = (KeyEventTool) tool; 

			keyTool.keyPressed((char) e.getKeyChar(), canvas); 

		}

	} 

    

	public void keyReleased(KeyEvent e) {} 

	public void keyTyped(KeyEvent e) {}



	public void mouseClicked(MouseEvent e)

	{

		canvas.requestFocus(); 

	}

}
