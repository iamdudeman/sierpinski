/* Tim Solum
 * solhub.me
 * 3-6-14
 * 
 * Sierpinski_Triangle.java
 * This file contains a class that is used to create Sierpinski Triangles. 
 * 8 generations makes it look nice
 */

package Sierpinski_triangle;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class SierpinskiTriangle {
	//The distance of each line to be drawn for the Sierpinski triangle
	final int distance = 5;
	
	//starts at A
	String _sierpinski = "A";
	StringBuilder _builder = new StringBuilder();
	//cause Blue is nice
	Color _color = Color.BLUE;
	
	/**
	 * Each evolution makes a nicer Sierpinski triangle. At least 8 generations makes it look nice.
	 */
	public void evolution(){
		//clear the builder
		_builder.delete(0, _builder.length());
		
		//loop through each character in the current generation
		for(int i = 0; i < _sierpinski.length(); i++){
			char temp = _sierpinski.charAt(i);
			switch (temp){
				//if it is an A then append "B-A-B"
				case 'A':
					_builder.append("B-A-B");
					break;
				//if it is a B then append "A+B+A"
				case 'B':
					_builder.append("A+B+A");
					break;
				//append + or - whenever we see one
				case '+':
					_builder.append("+");
					break;
				case '-':
					_builder.append("-");
					break;
				//should never be used!
				default:
					break;
			}
		}
		//set the current Sierpinski generation to what we just built
		_sierpinski = _builder.toString();
	}
	
	/**
	 * Draws the Sierpinski Triangle to a Graphics2S object <br>
	 * You will likely need to use the scale or translate methods of Graphics2D to be able to see it completely.
	 * @param g The Graphics2D object
	 */
	public void draw(Graphics2D g){
		//the line that we will be drawing
		Line2D.Double line = null;
		//the current point in x and y
		double x = 0.0;
		double y = 0.0;
		//the current point as a Point2D.Double
		Point2D.Double _current = new Point2D.Double(0, 0);
		//the angle we are drawing at
		double angle = 0;

		//set our color to be pretty
		g.setColor(_color);
		
		//loop through the Sierpinski character string for drawing directions
		for(int i = 0; i < _sierpinski.length(); i++){
			char temp = _sierpinski.charAt(i);
			switch (temp){
				//if A or B then calculate the next point needed to draw our line
				case 'A':
					//the x coordinate of the next point using trig
					x = _current.x + distance * Math.cos(angle);
					//the y coordinate of the next point using trig
					y = _current.y + distance * Math.sin(angle);
					break;
				case 'B':
					x = _current.x + distance * Math.cos(angle);
					y = _current.y + distance * Math.sin(angle);
					break;
				//if + then subtract pi/3 (60 degrees)
				case '+':
					angle -= Math.PI / 3;
					break;
				//if - then add pi/3 (60 degrees)
				case '-':
					angle += Math.PI / 3;
					break;
				//again....hopefully never used
				default:
					break;
			}
			//whenever the current character is A or B we draw
			if(temp == 'A' || temp == 'B'){
				//The line that we will be drawing using current point and next point
				line = new Line2D.Double(_current.getX(), _current.getY(), x, y);
				g.draw(line);
				//set the current point to our next point
				_current = new Point2D.Double(x, y);
			}
		}
	}
}
