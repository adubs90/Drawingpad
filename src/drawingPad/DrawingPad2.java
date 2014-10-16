package drawingPad;



import java.awt.*;

import java.awt.event.*;

import java.util.*;

import javax.swing.*; 



public class DrawingPad2 extends DrawingPad

{

	public DrawingPad2()

	{

		this(true);  

	}



	public DrawingPad2(boolean isApplet)

	{

		super(isApplet); 

		canvas.addKeyListener((KeyListener) listener); 

	}



	public static void main(String[] args)

	{

		JFrame frame = new JFrame();

		frame.setTitle("Drawing Pad 2");

		frame.setBackground(Color.lightGray);

		frame.getContentPane().setLayout(new BorderLayout());

		frame.getContentPane().add(new DrawingPad2(false), BorderLayout.CENTER);

		frame.addWindowListener(new AppCloser()); 

		frame.pack();

		frame.setSize(700, 500);

		frame.show();

	}



	protected EventListener makeCanvasListener(ScribbleCanvas canvas)

	{

		return new KeyToolListener(this, canvas); 

	}



	protected void initActions()

	{

		actions = new Vector();     

		actions.addElement(new ToolAction("Scribble", 

				      getImageIcon("scribble.gif"),

				      "scribble tool", this, 

				      currentTool = new ScribbleTool())); 

		actions.addElement(new ToolAction("Line", new ToolIcon(ToolIcon.LINE),

				      "draw line segments", this, 

				      new TwoEndsShapeTool(new LineShape()))); 

		actions.addElement(new ToolAction("Rectangle", new ToolIcon(ToolIcon.RECT),

				      "draw rectangles", this, 

				      new TwoEndsShapeTool(new RectShape()))); 

		actions.addElement(new ToolAction("Oval", new ToolIcon(ToolIcon.OVAL),

				      "draw ovals", this, 

				      new TwoEndsShapeTool(new OvalShape()))); 

		actions.addElement(new ToolAction("Filled Rectangle", 

				      new ToolIcon(ToolIcon.FILLRECT),

				      "draw filled rectangles", this, 

				      new TwoEndsShapeTool(new FilledRectShape()))); 

		actions.addElement(new ToolAction("Filled Oval", 

				      new ToolIcon(ToolIcon.FILLOVAL),

				      "draw filled ovals", this, 

				      new TwoEndsShapeTool(new FilledOvalShape()))); 

		actions.addElement(new ToolAction("Text", new ToolIcon(ToolIcon.TEXT),

				      "type text", this, 

				      new TextTool())); 

		actions.addElement(new ToolAction("Eraser", 

				      getImageIcon("eraser.gif"),

				      "eraser tool", this, 

				      new EraserTool()));   

	}

}

