package drawingPad;



import java.awt.*;



public interface Tool

{

	void mousePressed(Point p, ScribbleCanvas canvas); 

	void mouseReleased(Point p, ScribbleCanvas canvas); 

	void mouseDragged(Point p, ScribbleCanvas canvas); 

}

