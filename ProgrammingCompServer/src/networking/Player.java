package networking;

import submission.ProblemSubmission;

public class Player implements Comparable {
	private String username;
	private int[] problemSubmissions=new int[500];//max of 500 problems
	private boolean[] correctProblems=new boolean[500];
	
	public Player(String username) {
		this.username=username;
		for (int i=0; i<problemSubmissions.length; i++) {
			correctProblems[i]=false;
			problemSubmissions[i]=0;
		}
	}
	
	public boolean isUsername(String username) {
		return username.equals(this.username);
	}
	
	public void addSubmission(ProblemSubmission submission) {
		problemSubmissions[submission.getQuestionNumber()]++;
		correctProblems[submission.getQuestionNumber()]=correctProblems[submission.getQuestionNumber()]||submission.isCorrect();
	}

	public int compareTo(Object o) {
		if (o instanceof Player) {
			int me=getCorrectProblems();
			int them=((Player)o).getCorrectProblems();
			if (me>them) {
				return 1;
			}
			if (me<them) {
				return -1;
			}
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
		return 99;
	}
	
	public boolean gotProblemCorrect(int problem) {
		return correctProblems[problem];
	}
	
	public int getProblemSubmissions(int problem) {
		return problemSubmissions[problem];
	}
}
