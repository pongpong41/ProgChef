package model.food;

public interface Ripenable {
	
	public static final double TIMEFORCOMPLETECHOPPED = 360;
	
	public abstract void setStateWhenCompleteRipen();
	public abstract void addTimeToRipened();
	public abstract double getTimeToRippened();
}
