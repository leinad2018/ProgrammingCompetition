package submission;

public class ClarificationSubmission implements Submittable {
	
	private long submissionTime;
	private String question, answer, username;
	
	
	public ClarificationSubmission(String username, String question, String answer) {
		submissionTime=System.currentTimeMillis();
		this.username=username;
		this.question=question;
		this.answer=answer;
	}
	
	public long getSubmissionTime() {
		return submissionTime;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer=answer;
	}

	public String getSubmittedBy() {
		return username;
	}
}
