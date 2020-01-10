/**
 * Create Point3D class from  x,y,z co-oridinates
 * @author      Arpandeep Singh sing1244@algonquinlive.com
 * @version     1.0              
 */


public class Point3D {
    private  double x,y,z;
     
    /**
     * Point3D Initial Constructor
	 * @param x coordinate
	 * @param y coordinate
	 * @param z coordinate
	 */
    public Point3D(double a,double b,double c) {   	 
    	x=a;
    	y=b;
    	z=c;	 
    }
    
    /**
     * Get the String of x,y,z
	 * @return x y z string  of the Point3D
	 */
	public String toString() {
    	return x+" "+y+" "+z;
    }
	
	/**
	 * Get the value of x
	 * @return x variable of the Point3D
	 */
	public double getX() {
		return x;
	}
    
	/**
	 * Set the Value of X
	 * @param value to be set
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Get the value of y
	 * @return y variable of the Point3D
	 */
	public double getY() {
		return y;
	}

	/**
	 * Set the Value of Y
	 * @param value of y to be set
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Get the value of z
	 * @return z variable of the Point3D
	 */
	public double getZ() {
		return z;
	}
 
	/**
	 * Set the Value of Z
	 * @param value of z to be set
	 */
	public void setZ(double z) {
		this.z = z;
	}


	/**
	 * Calculate Normal Point3D at a unit Distance from the Facet of Point3D arguments
	 * @param Point3D v1
	 * @param Point3D v2
	 * @param Point3D v3
	 * @return Calculated Normal Point3D
	 */
	public static Point3D calcNormal(Point3D v1, Point3D v2, Point3D v3) {
		
	   double a1 = v2.x - v1.x; 
	   double b1 = v2.y - v1.y; 
	   double c1 = v2.z - v1.z; 
	   double a2 = v3.x - v1.x; 
	   double b2 = v3.y - v1.y; 
	   double c2 = v3.z - v1.z; 
	   
	   double a = b1 * c2 - b2 * c1; 
	   double b = a2 * c1 - a1 * c2; 
	   double c = a1 * b2 - b1 * a2;
	   
	   double mag = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)+Math.pow(c, 2));
	   
		Point3D normal = new Point3D(a/mag,b/mag,c/mag);
		return normal;
	}



    
}
