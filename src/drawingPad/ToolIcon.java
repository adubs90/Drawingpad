package drawingPad;



import java.awt.*;

import java.awt.event.*;

import javax.swing.*;



public class ToolIcon implements Icon

{

	public static final int SCRIBBLE = 0; 

	public static final int LINE = 1; 

	public static final int RECT = 2; 

	public static final int OVAL = 3; 

	public static final int FILLRECT = 4; 

	public static final int FILLOVAL = 5; 

	public static final int TEXT = 6; 

	public static final int ERASER = 7; 



	protected Dimension dim = new Dimension(36, 36); 

	protected int id; 

  

	public ToolIcon(int id)

	{

		this.id = id; 

	}



	public void paintIcon(Component c, Graphics g, int x, int y)

	{

		Color oldColor = g.getColor();

		g.setColor(c.getBackground());

		g.fillRect(x, y, dim.width, dim.height);

		g.setColor(Color.black);

		int x0 = x + 2; 

		int y0 = y + 2; 

		int w0 = dim.width - 4; 

		int h0 = dim.height - 4;

		switch (id)

		{

		case SCRIBBLE:      

			break; 

		case LINE:

			g.drawLine(x0, y0, x0 + w0, y0 + h0); 

			break; 

		case RECT:

			g.drawRect(x0, y0, w0, h0); 

			break; 

		case OVAL:

			g.drawOval(x0, y0, w0, h0); 

			break; 

		case FILLRECT:

			g.fillRect(x0, y0, w0, h0); 

			break; 

		case FILLOVAL:

			g.fillOval(x0, y0, w0, h0); 

			break; 

		case TEXT:

			g.setFont(new Font("Serif", Font.BOLD, h0)); 

			FontMetrics fm = g.getFontMetrics();

			g.drawString("T", x0, y0 + fm.getAscent()); 

			break; 

		case ERASER:

			break; 

		}

		g.setColor(oldColor);

	}

  

	public int getIconWidth() { return dim.width; }

	public int getIconHeight() { return dim.height; }

}

