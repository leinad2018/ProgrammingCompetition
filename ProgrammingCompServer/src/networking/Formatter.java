package networking;

import java.util.ArrayList;
import java.util.Collections;

import submission.ProblemSubmission;
import submission.Submittable;

public class Formatter {
	public static final int problems=11;
	
	public static String[][] formatInput(Submittable[] submissions, long competitionStartTime) {
		ArrayList<ProblemSubmission> problemSubmissions=new ArrayList<>();
		for (Submittable s:submissions) {
			if (s instanceof ProblemSubmission) {
				problemSubmissions.add((ProblemSubmission)s);
			}//otherwise don't add it
		}
		
		ArrayList<Player> players=new ArrayList<>();
		outer: for (ProblemSubmission submission:problemSubmissions) {
			for (int i=0; i<players.size(); i++) {
				Player p=players.get(i);
				if (p.isUsername(submission.getSubmittedBy())) {
					p.addSubmission(submission);
					continue outer;
				}
			}
			
			players.add(new Player(submission.getSubmittedBy(), competitionStartTime));
			players.get(players.size()-1).addSubmission(submission);
		}
		
		Collections.sort(players);
		String[][] toReturn=new String[players.size()+1][problems+3];
		toReturn[0][0]="Name";
		toReturn[0][1]="Problems Correct";
		toReturn[0][2]="Penalty Points";
		for (int i=0; i<problems; i++) {
			toReturn[0][3+i]=ProblemSubmission.questionNumberToQuestionName(i);
		}
		for (int i=0; i<players.size(); i++) {
			toReturn[i+1][0]=players.get(i).getName();
			toReturn[i+1][1]=players.get(i).getCorrectProblems()+"";
			toReturn[i+1][2]=players.get(i).getPenaltyPoints()+"";
			for (int j=0; j<problems; j++) {
				if (players.get(i).gotProblemCorrect(j)) {
					toReturn[i+1][3+j]="Correct ("+players.get(i).getProblemSubmissions(j)+")";
				}
				else {
					toReturn[i+1][3+j]=players.get(i).getProblemSubmissions(j)+"";
				}
			}
		}
		return toReturn;
	}
}
