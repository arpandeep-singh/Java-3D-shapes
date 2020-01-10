package curves;

public class Paraboloid implements Curve {
    private final double RADIUS;
    private final double HEIGHT;
    
     
    public Paraboloid(double radius,double height) {
    	this.RADIUS=radius;
    	this.HEIGHT=height;
    }
   
	@Override
	public double getMaxX() {
		// TODO Auto-generated method stub
		return 5*RADIUS/Math.sqrt(HEIGHT);
	}

	@Override
	public double getMaxY() {
		// TODO Auto-generated method stub
		return 5*RADIUS/Math.sqrt(HEIGHT);
	}

	@Override
	public double getMinX() {
		// TODO Auto-generated method stub
		return -5*RADIUS/Math.sqrt(HEIGHT);
	}

	@Override
	public double getMinY() {
		// TODO Auto-generated method stub
		return -5*RADIUS/Math.sqrt(HEIGHT);
	}

	@Override
	public double getStepSize() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double getZ(double x, double y) {
		// TODO Auto-generated method stub
		return 0.1*(Math.pow(x, 2)+Math.pow(y, 2));
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Paraboloid"+"-"+RADIUS+"-"+HEIGHT;
	}

}
