package submission;

public class ProblemSubmission implements Submittable {

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
			return "HelloWorld";
		default:
			return "Unsupported Question number...";	
		}
	}
	private boolean correct;
	private int problemNumber;
	private String returnMessage, username;
	
	private long submissionTime;
	
	public ProblemSubmission(String username, int problemNumber, boolean correct, String returnMessage) {
		this.submissionTime=System.currentTimeMillis();
		this.username=username;
		this.problemNumber=problemNumber;
		this.correct=correct;
		this.returnMessage=returnMessage;
	}


	@Override
	public String getAnswer() {
		return returnMessage;
	}


	@Override
	public String getQuestion() {
		return questionNumberToQuestionName(problemNumber);
	}
	
	public int getQuestionNumber() {
		return problemNumber;
	}
	
	@Override
	public long getSubmissionTime() {
		return submissionTime;
	}

	@Override
	public String getSubmittedBy() { 
		return username;
	}

	public boolean isCorrect() {
		return correct;
	}
}
