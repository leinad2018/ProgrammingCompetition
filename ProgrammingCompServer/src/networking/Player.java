package networking;

import submission.ProblemSubmission;

public class Player implements Comparable {
	private String username;
	private int[] problemSubmissions=new int[500];//max of 500 problems
	private boolean[] correctProblems=new boolean[500];
	private long[] problemCompletionTime=new long[500];
	private long competitionStartTime;
	
	
	public Player(String username, long competitionStartTime) {
		this.username=username;
		for (int i=0; i<problemSubmissions.length; i++) {
			correctProblems[i]=false;
			problemSubmissions[i]=0;
			problemCompletionTime[i]=0;
		}
		this.competitionStartTime=competitionStartTime;
	}
	
	public boolean isUsername(String username) {
		return username.equals(this.username);
	}
	
	public void addSubmission(ProblemSubmission submission) {
		problemSubmissions[submission.getQuestionNumber()]++;
		correctProblems[submission.getQuestionNumber()]=correctProblems[submission.getQuestionNumber()]||submission.isCorrect();
		if (submission.isCorrect()) {
			problemCompletionTime[submission.getQuestionNumber()]=submission.getSubmissionTime()-competitionStartTime;
		}
	}

	public int compareTo(Object o) {
		if (o instanceof Player) {
			int me=getCorrectProblems();
			int them=((Player)o).getCorrectProblems();
			if (me>them) {
				return -1;
			}
			if (me<them) {
				return 1;
			}
		}
		int me=getPenaltyPoints();
		int them=((Player)o).getPenaltyPoints();
		if (me>them) {
			return 1;
		}
		if (them>me) {
			return -1;
		}
		return 0;
	}
	
	public int getCorrectProblems() {
		int total=0;
		for (boolean b:correctProblems) {
			if (b) {
				total++;
			}
		}
		return total;
	}
	
	public String getName() {
		return username;
	}
	
	public int getPenaltyPoints() {
		int total=0;
		for (int problemNumber=0; problemNumber<correctProblems.length; problemNumber++) {
			if (gotProblemCorrect(problemNumber)) {
				total+=problemCompletionTime[problemNumber]/1000/60;
				total+=20*(getProblemSubmissions(problemNumber)-1);
			}
		}
		return total;
	}
	
	public boolean gotProblemCorrect(int problem) {
		return correctProblems[problem];
	}
	
	public int getProblemSubmissions(int problem) {
		return problemSubmissions[problem];
	}
}
