package submission;

public class ClarificationSubmission implements Submittable {
	
	private String question, answer, username;
	private long submissionTime;
	
	
	public ClarificationSubmission(String username, String question, String answer, int problemNumber) {
		submissionTime=System.currentTimeMillis();
		this.username=username;
		this.question=ProblemSubmission.questionNumberToQuestionName(problemNumber)+": "+question;
		this.answer=answer;
	}
	
	@Override
	public String getAnswer() {
		return answer;
	}

	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public long getSubmissionTime() {
		return submissionTime;
	}
	
	@Override
	public String getSubmittedBy() {
		return username;
	}

	public void setAnswer(String answer) {
		this.answer=answer;
	}
	
	@Override
	public String toString() {
		return question+"\nFrom "+username;
	}
	
}
