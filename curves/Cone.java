package curves;

public class Cone implements Curve {
private final double a ;
	
	public Cone(double a){
		this.a=a;
	}
	public double getMaxX() {
		// TODO Auto-generated method stub
		return -10;
	}

	@Override
	public double getMaxY() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public double getMinX() {
		// TODO Auto-generated method stub
		return -10;
	}

	@Override
	public double getMinY() {
		// TODO Auto-generated method stub
		return -10;
	}

	@Override
	public double getStepSize() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double getZ(double x, double y) {
		// TODO Auto-generated method stub
		return Math.sqrt((x*x+y*y)/a*a);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Cone-"+a;
	}

}
