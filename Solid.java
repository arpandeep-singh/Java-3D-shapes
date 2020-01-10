import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
/**
 * Create a solid 
 * @author      Arpandeep Singh sing1244@algonquinlive.com
 * @version     1.0              
 */

public class Solid {
	private String name;
	private List<Facet> facets= new ArrayList<>();

	/**
	 * Solid Default Constructor
	 */
	public Solid() {
		name="";
	}
	/**
	 * @param name
	 */
	public Solid(String name) {
		this.name=name;

	}
	
	/**
	 * Add the Facet to the Matrix
	 * @param Facet 
	 * @return True if facet gets added to the list and False if not.
	 */
	public boolean addFacet(Facet facet) {

		facets.add(facet);
		if(facets.get(facets.size()-1)!=null)
			return true;
		else
			return false;
	}
	
	/**
	 * Add the Facet to the Matrix
	 * @param vertex
	 * @return False if Point3D's are less than 3
	 */
	public boolean addFacet(Point3D... vertex) {

		//condition to check sure  if number of arguments passed in the method is greater than 3 or not 
		if(vertex.length<3) {
			return false;
		} 
		
		//making facets from the Point3D points
		for(int i=1;i<vertex.length-1;i++) {
			Facet f = new Facet(vertex[0],vertex[i],vertex[i+1]);
			this.addFacet(f);	
		}

		return true;
	}

	/**
	 * Generate the STL Format
	 * 
	 * @return Solid String
	 */
	public String toString() {
		String s= "solid "+name;

		for(Facet f: facets) {

			s+=f+ "\n endloop\nendfacet";
		}
		s+="\nendsolid "+name;
		return s;

	}
	/**
	 * Print the Solid to File
	 * @param path
	 * @throws IOexception
	 * 
	 */
	public void toTextFile(Path path)throws IOException {
		
		//using FileWriter to write data into a file
		FileWriter myWriter = new FileWriter(path.toString());
		myWriter.write(this.toString());
		myWriter.close();
		


	}


}
