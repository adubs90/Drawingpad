package drawingPad;



import java.awt.*;

import java.awt.event.*;

import java.net.URL;

import java.net.MalformedURLException;

import java.util.*;

import javax.swing.*; 



public class DrawingPad extends Scribble2

{

	protected Vector actions; 

	protected Tool currentTool;

	

	public DrawingPad()

	{

		this(true); 

	}



	public DrawingPad(boolean isApplet)

	{

		super(isApplet); 

		if (!isApplet)

		{

			init(); 

		}

	}



	public void init()

	{

		initActions();     

		getContentPane().add(makeToolBar(actions), BorderLayout.WEST); 

		getContentPane().add(makeMenuBar(actions), BorderLayout.NORTH); 

	}



	public static void main(String[] args)

	{

		JFrame frame = new JFrame();

		frame.setTitle("Drawing Pad");

		frame.setBackground(Color.lightGray);

		frame.getContentPane().setLayout(new BorderLayout());

		frame.getContentPane().add(new DrawingPad(false), BorderLayout.CENTER);

		frame.addWindowListener(new AppCloser()); 

		frame.pack();

		frame.setSize(600, 400);

		frame.show();

	}



	public void setCurrentTool(Tool tool)

	{

		currentTool = tool; 

	}



	public Tool getCurrentTool()

	{

		return currentTool; 

	}



	protected EventListener makeCanvasListener(ScribbleCanvas canvas)

	{

		return new ToolListener(this, canvas); 

	}



	protected ImageIcon getImageIcon(String filename)

	{

		if (isApplet)

		{

			try

			{

				URL url = new URL(getCodeBase(), filename); 

				return new ImageIcon(url); 

			} catch (MalformedURLException e)

			{

				return null; 

			} 

		} 

		else

		{

			return new ImageIcon(filename);

		}

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

				      new TwoEndsTool(TwoEndsTool.LINE))); 

		actions.addElement(new ToolAction("Rectangle", new ToolIcon(ToolIcon.RECT),

				      "draw rectangles", this, 

				      new TwoEndsTool(TwoEndsTool.RECT))); 

		actions.addElement(new ToolAction("Oval", new ToolIcon(ToolIcon.OVAL),

				      "draw ovals", this, 

				      new TwoEndsTool(TwoEndsTool.OVAL))); 

		actions.addElement(new ToolAction("Eraser", 

				      getImageIcon("eraser.gif"),

				      "eraser tool", this, 

				      new EraserTool()));     

	}



	protected Component makeToolBar(Vector actions)

	{

		Box toolbar = new Box(BoxLayout.Y_AXIS); 

		Enumeration enum = actions.elements(); 

		while (enum.hasMoreElements())

		{

			Action a = (Action) enum.nextElement(); 

			JButton button = new JButton((Icon) a.getValue(Action.DEFAULT)); 

			button.setToolTipText((String) a.getValue(Action.SHORT_DESCRIPTION));

			button.addActionListener(a);

			toolbar.add(button);       

		}

		toolbar.add(Box.createVerticalGlue()); 

		return toolbar;

	}



	protected Component makeMenuBar(Vector actions)

	{

		JMenuBar menubar = new JMenuBar(); 

		JMenu tools = new JMenu("Tool"); 

		Enumeration enum = actions.elements(); 

		while (enum.hasMoreElements())

		{

			Action a = (Action) enum.nextElement(); 

			tools.add(a); 

		}    

		menubar.add(tools);

		JMenu help = new JMenu("Help");     

		help.add(new AboutAction());

		menubar.add(help);

		return menubar;

	}



	class AboutAction extends AbstractAction

	{

		public AboutAction()

		{

			super("About"); 

		}

    

		public void actionPerformed(ActionEvent event)

		{ 

			JOptionPane.showMessageDialog(null, "DrawingPad version 1.0\nCopyright (c) Xiaoping Jia 1998", "About", 

				    JOptionPane.INFORMATION_MESSAGE); 

		}

	}

}


