import java.awt.*;

/**
 * A shape that can be moved around.
 * 
 * @author Kaan Balci
*/
public interface MovingShape
{
   /**
      Draws the shape.
      @param g2 the graphics context
   */
   void draw(Graphics2D g2);
   
   /**
      Move shape by an amount.
      @param tx moving in x-direction
      @param ty moving in y-direction
   */
   void translate(int tx, int ty);
}