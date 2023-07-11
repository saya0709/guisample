package gui.bookkeeping.sample02;

public class ProBookKeeping {
	int id;
	String subject;
	
	public ProBookKeeping(int id, String subject) {
		setId(id);
		setSubject(subject);
	}
	
	
	//getter, setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	


}
