public class Trone {
	private int x;
	private int y;

	public Trone(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Trone [x=" + y + ", y=" + x + "]";
	}
	
	public boolean equals(Trone that) {
	    return (that instanceof Trone && this.x==that.getX() && this.y==that.getY());
	}

}
