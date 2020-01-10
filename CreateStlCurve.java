
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import curves.ConeCurve;
import curves.Curve;

/**
 * Application to create a text STL file for a Cone curve
 * @author      Howard Rosenblum rosenbh@algonquincollege.com
 * @version     1.0              
 */
public class CreateStlCurve {
	private List<List<Point3D>> list;

	/**
	 * Create a matrix of points
	 */
	public void createMatrix(Curve curve)
	{
		// TODO in lab 4, based on createList in PointList 


		
		double maxX= curve.getMaxX();
		double maxY=curve.getMaxY();

		double minX= curve.getMinX();
		double minY= curve.getMinY();
		double stepSize=curve.getStepSize();

		int rows = (int)((maxX-minX)/stepSize +1);
		int columns = (int)((maxY-minY)/stepSize +1);

		list=new ArrayList<List<Point3D>>(rows);
		double x= minX;
		double y= minY;
		double x1= maxX + minX;
		double y1= maxY + minY;

		for(int i=0; i<rows; i++)
		{
			y=minY;
			x1 = maxX + minX;

			List<Point3D> row = new ArrayList<Point3D>(columns);  
			list.add(row); // add values in the rows
			for(int j=0; j<(int) columns; j++)
			{
				Point3D point=new Point3D(x1,y1,curve.getZ(x,y)); 
				row.add(point);
				y+=stepSize;
				x1+=stepSize;
			}
			//  add rows values in the list
			x+=stepSize;
			y1+=stepSize;

		}
//		for(List l : list) {
//			System.out.println(l);
//		}
	}

	/**
	 * Create Solid based on values in matrix
	 * @param name Name of the solid
	 * @return Generated solid
	 */
	public Solid createSolid(String name)
	{
		Solid solid = new Solid(name);

		int height=list.size()-1;
		int width=list.get(0).size()-1;

		// Create curve
		for(int h=0; h<height; h++)
		{
			for(int w=0; w<width; w++)
			{
				// as viewed from above
				solid.addFacet(
						list.get(h).get(w),    // bottom left
						list.get(h).get(w+1),  // bottom right
						list.get(h+1).get(w+1),// top right
						list.get(h+1).get(w)); // top left
			}
		}

		// Create bottom edge
		// TODO in lab 5
		for(int w=0;w<width;w++) {
			solid.addFacet(
					new Point3D(list.get(0).get(w+1).getX(),0,0),
					new Point3D(list.get(0).get(w).getX(),0,0),
					list.get(0).get(w),
					list.get(0).get(w+1)
					);
		}


		// Create top edge
		// TODO in lab 5
		double maxY = list.get(height).get(width).getY();
		for(int w=0;w<width;w++) {
			solid.addFacet(
					new Point3D(list.get(height).get(w+1).getX(),maxY,0),
					new Point3D(list.get(height).get(w).getX(),maxY,0),
					list.get(height).get(w),
					list.get(height).get(w+1)
					);
		}

		// Create left edge
		// TODO in lab 5
		for(int h=0;h<height;h++) {
			solid.addFacet(
					new Point3D(0,list.get(h+1).get(0).getY(),0),
					new Point3D(0,list.get(h).get(0).getY(),0),
					list.get(h).get(0),
					list.get(h+1).get(0)
					);
		}

		// Create right edge
		// TODO in lab 5
		double maxX = list.get(height).get(width).getX();
		for(int h=0;h<height;h++) {
			solid.addFacet(
					new Point3D(maxX,list.get(h+1).get(width).getY(),0),
					new Point3D(maxX,list.get(h).get(width).getY(),0),
					list.get(h).get(width),
					list.get(h+1).get(width)
					);
		}

		// Create base
		// TODO in lab 5



		return solid;
	}

	/**
	 * Print the points to the console
	 */
	public void printMatrix()
	{
		for(List<Point3D> row : list)
		{
			for(Point3D value : row)
				System.out.print("("+value+") ");
			System.out.println();
		}
	}

	/**
	 * Application main
	 * @param arg Commandline argument (not used)
	 */
	
		

}
