package gui.class302.singleton.sample02;



import java.util.Date;

public class Kakeibo {
	
	Date date;
	int id;
	String memo;
	int deposit;
	int withdraw;
	
	public Kakeibo(Date date,int id, String memo, int deposit, int withdraw) {
		setDate(date);
		setId(id);
		setMemo(memo);
		setDeposit(deposit);
		setWithdraw(withdraw);
	}

	
	
	
	//getter, setter
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
	
	
	

}
