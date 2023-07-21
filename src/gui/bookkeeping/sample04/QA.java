package gui.bookkeeping.sample04;

public class QA {
	int id;
	String qasub;
	String question;
	String answer;
	int title_id;
	
	public QA(int id, String qasub, String question, String answer, int title_id) {
		setId(id);
		setQasub(qasub);
		setQuestion(question);
		setAnswer(answer);
		setTitle_id(title_id);
	}
	
	
	
	
	//getter, setter
	public String getQasub() {
		return qasub;
	}

	public void setQasub(String qasub) {
		this.qasub = qasub;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getTitle_id() {
		return title_id;
	}
	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}
	
	
	

}
