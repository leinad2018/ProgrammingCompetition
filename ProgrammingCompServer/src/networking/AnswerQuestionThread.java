package networking;

import java.util.ArrayList;
import java.util.Scanner;

import submission.ClarificationSubmission;
import submission.Submittable;

public class AnswerQuestionThread implements Runnable {

	@Override
	public void run() {
		System.out.println("---------------Answer Question Thread---------------");
		Scanner s=new Scanner(System.in);
		while (true) {
			try {
				Submittable[] submitted=MultiServer.getSubmittedThings();
				ArrayList<ClarificationSubmission> unansweredQuestions=new ArrayList<ClarificationSubmission>();
				for (Submittable checking : submitted) {
					if (checking instanceof ClarificationSubmission
							&&((ClarificationSubmission)checking).getAnswer().equalsIgnoreCase("<Unanswered>")) {
						unansweredQuestions.add((ClarificationSubmission)checking);
					}
				}
				if (unansweredQuestions.size()!=0) {
					System.out.println(unansweredQuestions.size()+" unanswered question(s). Enter a number 0-"
							+(unansweredQuestions.size()-1)+":");
					int index=s.nextInt();
					s.nextLine();
					System.out.print("Question: ");
					System.out.println(unansweredQuestions.get(index));
					String newAnswer=s.nextLine();
					unansweredQuestions.get(index).setAnswer(newAnswer);
					System.out.println("Thanks...");
				}
				else {
					System.out.println("No questions, waiting...");
				}

			} catch (Exception e) {
				System.out.println("Invalid input.");
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
