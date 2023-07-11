package gui.bookkeeping.sample03;

public class Title {
	int id;
	String title;
	int subject_id;
	
	
	public Title(int id, String title, int subject_id) {
		setId(id);
		setTitle(title);
		setSubject_id(subject_id);
	}
	
	
	
	//getter, setter
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getSubject_id() {
		return subject_id;
	}


	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	
	
	
	

}
