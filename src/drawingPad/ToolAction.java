package drawingPad;



import java.awt.*;

import java.awt.event.*;

import java.util.EventListener;

import javax.swing.*; 



public class ToolAction extends AbstractAction

{

	protected DrawingPad drawingPad;

	protected Tool tool; 

	

	public ToolAction(String name, Icon icon, String tip, DrawingPad drawingPad, Tool tool)

	{

		super(name); 

		putValue(Action.DEFAULT, icon);

		putValue(Action.SHORT_DESCRIPTION, tip);

		setEnabled(tool != null); 

		this.drawingPad = drawingPad; 

		this.tool = tool; 

	}

 

	public void actionPerformed(ActionEvent event)

	{ 

		drawingPad.setCurrentTool(tool); 

	}

}

