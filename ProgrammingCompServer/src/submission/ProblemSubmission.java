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
			return "HelloWorld";
		case 1:
			return "Strings";
		case 2:
			return "Doors";
		case 3:
			return "Lonely";
		case 4:
			return "Recursion";
		case 5:
			return "Toaster";
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
