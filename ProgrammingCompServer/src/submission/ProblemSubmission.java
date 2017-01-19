package submission;

public class ProblemSubmission implements Submittable {

	private long submissionTime;
	private int problemNumber;
	private boolean correct;
	private String returnMessage, username;
	
	public ProblemSubmission(String username, int problemNumber, boolean correct, String returnMessage) {
		this.submissionTime=System.currentTimeMillis();
		this.username=username;
		this.problemNumber=problemNumber;
		this.correct=correct;
		this.returnMessage=returnMessage;
	}
	
	public long getSubmissionTime() {
		return submissionTime;
	}


	public String getQuestion() {
		return questionNumberToQuestionName(problemNumber);
	}


	public String getAnswer() {
		return returnMessage;
	}
	
	public boolean isCorrect() {
		return correct;
	}
	
	public static String questionNumberToQuestionName(int questionNumber) {
		switch(questionNumber) {
		case 0:
			return "Strings";
		case 1:
			return "Doors";
		case 2:
			return "Lonely";
		case 3:
			return "Recursion";
		case 4:
			return "Toaster";
		case 5:
			return "Trees";
		default:
			return "Unsupported Question number...";	
		}
	}

	public String getSubmittedBy() { 
		return username;
	}

	public int getQuestionNumber() {
		return problemNumber;
	}
}
