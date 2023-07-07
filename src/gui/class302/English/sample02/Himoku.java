package gui.class302.English.sample02;


public class Himoku {
	int id;
	String name;
	String memo;
	
	public Himoku(String name, String memo) {
		setName(name);
		setMemo(memo);
	}
	
	
	//getter, setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
}
