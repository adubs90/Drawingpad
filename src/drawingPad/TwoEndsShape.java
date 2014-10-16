package drawingPad;



import java.awt.*; 



public interface TwoEndsShape

{

	void drawShape(Graphics g, int x1, int y1, int x2, int y2); 

	void drawOutline(Graphics g, int x1, int y1, int x2, int y2); 

}

