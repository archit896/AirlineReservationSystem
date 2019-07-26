package bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class QuesAns {
	private String ques;
	private String ans;
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	@Override
	public String toString() {
		return "QuesAns [ques=" + ques + ", ans=" + ans + "]";
	}
	public QuesAns(String ques, String ans) {
		super();
		this.ques = ques;
		this.ans = ans;
	}
	public QuesAns() {
		super();
		// TODO Auto-generated constructor stub
	}
}
