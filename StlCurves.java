import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import curves.Cone;
import curves.ConeCurve;
import curves.Curve;
import curves.HalfSphere;
import curves.MonkeySaddle;
import curves.Paraboloid;

public class StlCurves {


	/**
	 * Application main
	 * @param arg Commandline argument (not used)
	 */

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Solid solid;
		Path path;
		String name="";

		ConeCurve cc = new ConeCurve();
		MonkeySaddle ms = new MonkeySaddle();
		HalfSphere hs = new HalfSphere(25.0);
		Paraboloid pb = new Paraboloid(25,25);
		

		List<Curve> list = new ArrayList<Curve>();

		list.add(cc);
		list.add(ms);
		list.add(hs);
		list.add(pb);

		for(int i=0;i<list.size();i++) {
			System.out.println((i+1)+" "+list.get(i).getName());
		}

		System.out.print("Which curve number do you want ?");

		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		
		CreateStlCurve curve = new CreateStlCurve();

		if(!(option>list.size() || option<0)) {
		curve.createMatrix(list.get(option-1));
		solid = curve.createSolid(list.get(option-1).getName());
		name = "c:\\temp\\"+list.get(option-1).getName()+".stl";
		path = Paths.get(name);
		
		try {
		solid.toTextFile(path);		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(name+" has been created");
		
		}
		else {
			System.out.println("Invalid Number, no curve created");
		}


	}

}
