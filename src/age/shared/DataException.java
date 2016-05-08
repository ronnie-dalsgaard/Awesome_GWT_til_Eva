package age.shared;

public class DataException extends Exception {
	private static final long serialVersionUID = -2256684050038344466L;
	
	private Exception e;
	
	public DataException(Exception e){
		this.e = e;
	}
	
	public DataException(){
		this.e = null;
	}
	
	public DataException(String msg){
		super(msg);
		this.e = null;
	}

	@Override
	public void printStackTrace() {
		if(this.e != null)
			System.err.println("DataException caused by: ");
		e.printStackTrace();
	}
	
	
}
