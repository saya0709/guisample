package gui.bookkeeping.sample02;

public class InnerTitle {
	int id;
	String innertitle;
	int title_id;
	
	public InnerTitle(int id, String innertitle, int title_id) {
		setId(id);
		setInnertitle(innertitle);
		setTitle_id(title_id);
	}
	
	
	
	//getter, setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInnertitle() {
		return innertitle;
	}

	public void setInnertitle(String innertitle) {
		this.innertitle = innertitle;
	}

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}
	
	
	
}
