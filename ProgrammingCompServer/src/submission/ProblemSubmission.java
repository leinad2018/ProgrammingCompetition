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
			return "hoo";
		case 1:
			return "fractal";
		case 2:
			return "fishytoo";
		case 3:
			return "flowers";
		case 4:
			return "sums";
		case 5:
			return "nurikabe";
		case 6:
			return "troll";
		case 7:
			return "dollar";
		case 8:
			return "bird";
		case 9:
			return "eggs";
		case 10:
			return "lobster";
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
