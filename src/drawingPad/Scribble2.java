package drawingPad;



import java.awt.*;

import java.awt.event.*;

import java.util.EventListener;

import javax.swing.*;



public class Scribble2 extends Scribble

{

	public Scribble2()

	{

		this(true);  

	}



	public Scribble2(boolean isApplet)

	{

		super(isApplet); 

		getContentPane().add(makeControlPanel(), BorderLayout.SOUTH);

	}



	public static void main(String[] args)

	{

		JFrame frame = new JFrame();

		frame.setTitle("Scribble Pad 2");

		frame.setBackground(Color.lightGray);

		frame.getContentPane().setLayout(new BorderLayout());

		frame.getContentPane().add(new Scribble2(false), BorderLayout.CENTER);

		frame.addWindowListener(new AppCloser()); 

		frame.pack();

		frame.setSize(600, 400);

		frame.show();

	}



	protected Component makeControlPanel()

	{

		JPanel controlPanel = new JPanel();

		JButton button = new JButton("Clear"); 

		controlPanel.add(button); 

		button.addActionListener(new ClearAction());



		controlPanel.add(Box.createHorizontalStrut(20)); 

    

		controlPanel.add(new JLabel("Pen color")); 

		JComboBox choice = new JComboBox();

		choice.addItem("black");

		choice.addItem("blue");

		choice.addItem("green");

		choice.addItem("red");

		choice.addItemListener(new ColorChoiceListener()); 

		Dimension d = choice.getPreferredSize(); 

		d.width += 10;

		choice.setPreferredSize(d);

		controlPanel.add(choice);

		return controlPanel; 

	} 

  

	class ClearAction extends AbstractAction

	{

		public ClearAction()

		{

			super("clear"); 

		}

		public void actionPerformed(ActionEvent event)

		{ 

			clearCanvas(); 

		}

	}



	class ColorChoiceListener implements ItemListener

	{

		public void itemStateChanged(ItemEvent event)

		{    

			if ("black".equals(event.getItem()))

				canvas.setPenColor(Color.black); 

			else if ("blue".equals(event.getItem()))

				canvas.setPenColor(Color.blue); 

			else if ("green".equals(event.getItem()))

				canvas.setPenColor(Color.green); 

			else if ("red".equals(event.getItem()))

				canvas.setPenColor(Color.red); 

		}

	}

	



	public void clearCanvas()

	{

		canvas.clearCanvas(); 

		canvas.repaint();

	}

}
