import java.awt.*;
import java.util.*;
import javax.swing.*;
/**
 * ShapeIcon handles putting shapes onto subwindow and creates array list of shapes
 * @author Kaan Balci
 *
 */
public class ShapeIcon implements Icon
{
	
	/**
	 * Constructor that instantiates the instance variables.
	 * 
	 * @param width of the shape
	 * @param height of the shape
	 */
	public ShapeIcon(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.shapes = new ArrayList<Shape>();
	}

	/** getters */
	public int getIconWidth()
	{ 
		return width; 
	}
	public int getIconHeight()
	{ 
		return height; 
	}
	
	/**
	 * adds shape to window
	 * @param newShape new shape
	 */
	public void addShape(Shape newShape)
	{ 
		shapes.add(newShape); 
	}
	
	
	/** Removes all the shapes from the window */
	public void removeAll()
	{ 
		shapes.removeAll(shapes); 
	}
	
	
	/** puts shapes in motion */
	public void motion()
	{
		int i = 0;
		
		while(i < shapes.size())
		{
			shapes.get(i).translate(1, 0);
			i++;
		}
	}
	
	
	
	/** Removes the shape from the window. */
	public void remove()
	{
		if(shapes.isEmpty() == false)
			shapes.remove(shapes.size() - 1);
	}
	
	

	/**
	 * Puts the shape onto the window.
	 * 
	 * @param _c shape
	 * @param _g shape
	 * @param _x x coordinate
	 * @param _y y coordinate
	 */
	public void paintIcon(Component _c, Graphics _g, int _x, int _y)
	{
		Graphics2D g2 = (Graphics2D) _g;
		int i = 0;
		
		while(i < shapes.size())
		{
			shapes.get(i).draw(g2);
			i++;
		}
	}
	private int width;
	private int height;
	private ArrayList<Shape> shapes;
}