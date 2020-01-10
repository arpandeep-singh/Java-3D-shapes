/**
 * Application to create a Facet from Point3D points
 * @author      Arpandeep Singh sing1244@algonquinlive.com
 * @version     1.0              
 */

public class Facet {
     private Point3D v1;
     private Point3D v2;
     private Point3D v3;
     private Point3D normal;
     
     /*
      * @param 3 Point3D vertexes
      * 
      */
     public Facet(Point3D v1,Point3D v2, Point3D v3) {
    	 this.v1=v1;
    	 this.v2=v2;
    	 this.v3=v3;
    	 this.normal = Point3D.calcNormal(v1, v2, v3);
     }
     

  /*
   * @return String of vertexes
   */
	public String toString() {
    	 return "\nfacet normal "+normal+
    			 "\n outer loop"+
    			 "\n  vertex "+v1+
    			 "\n  vertex "+v2+
    			 "\n  vertex "+v3;
     }
}
