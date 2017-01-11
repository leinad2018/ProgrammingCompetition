package networking;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import fileIO.FileLoader;
import submission.ClarificationSubmission;
import submission.ProblemSubmission;
import submission.Submittable;

public class MultiServerThread extends Thread {
	private Socket socket = null;
	private long competitionStartTime;

	public static String users = "asdf DavidHarmeyer";

	public MultiServerThread(Socket socket, long competitionStartTime) {
		super("MultiServer Thread");
		this.socket = socket;
		this.competitionStartTime = competitionStartTime;
	}

	public void run() {

		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				// System.out.println(inputLine);

				// ----------------Submit File--------------------
				if (inputLine.equals("submit file")) {
					String username = in.readLine();
					int problemNumber = Integer.parseInt(in.readLine());

					String line = in.readLine(), total = "";
					while (line.startsWith("fake:")) {
						total += line.substring("fake:".length()) + "\n";
						line = in.readLine();
					}
					String fileName = "..\\ProgComp\\" + username + "\\"
							+ ProblemSubmission.questionNumberToQuestionName(problemNumber) + "\\"
							+ ProblemSubmission.questionNumberToQuestionName(problemNumber) + ".java";
					FileLoader.writeToFile(fileName, total);
					String returnMessage = gradeSubmission(fileName, problemNumber, username);
					boolean correct = returnMessage.equals("Correct");
					MultiServer.submitSomething(new ProblemSubmission(username, problemNumber, correct, returnMessage));
				}

				// ----------------Request Clarification-----------
				if (inputLine.equals("request clarification")) {
					String username = in.readLine();
					int problemNumber = Integer.parseInt(in.readLine());
					String line = in.readLine(), total = "";
					while (line.startsWith("fake:")) {
						total += line.substring("fake:".length()) + "\n";
						line = in.readLine();
					}
					FileLoader.writeToFile("clarificationRequests/Problem_" + problemNumber + "_"
							+ System.currentTimeMillis() + "_" + username + ".txt", total);
					MultiServer.submitSomething(
							new ClarificationSubmission(username, total, "<Unanswered>", problemNumber));
				}

				// -----------------View Submission History------------
				if (inputLine.equals("get submission history")) {
					String username = in.readLine();
					Submittable[] submittedThings = MultiServer.getSubmittedThings();
					ArrayList<Submittable> submittedByUser = new ArrayList<Submittable>();
					for (Submittable s : submittedThings) {
						if (s.getSubmittedBy().equals(username)) {
							submittedByUser.add(s);
						}
					}
					String[][] toView = new String[submittedByUser.size()][4];
					for (int i = 0; i < submittedByUser.size(); i++) {
						toView[i][0] = submittedByUser.get(i).getSubmittedBy();
						toView[i][1] = submittedByUser.get(i).getSubmissionTime() + "";
						toView[i][2] = submittedByUser.get(i).getQuestion();
						toView[i][3] = submittedByUser.get(i).getAnswer();
					}

					for (int x = 0; x < toView.length; x++) {
						for (int y = 0; y < 4; y++) {
							toView[x][y] = toView[x][y].replaceAll("\n", " ");
							out.println("fake:" + toView[x][y]);
						}
					}
					out.println("Done");
				}

				// -------------------View Scores-----------------------
				if (inputLine.equals("view scores")) {
					String username = in.readLine();
					Submittable[] submittedThings = MultiServer.getSubmittedThings();
					String[][] toView = Formatter.formatInput(submittedThings, competitionStartTime);
					out.println(3 + Formatter.problems);
					for (int x = 0; x < toView.length; x++) {
						for (int y = 0; y < 3 + Formatter.problems; y++) {
							toView[x][y] = toView[x][y].replaceAll("\n", " ");
							out.println("fake:" + toView[x][y]);
						}
					}
					out.println("Done");
				}

				// -------------------VerifyUsernames-----------------------
				if (inputLine.equals("verify username")) {
					String username = in.readLine();
					if (users.contains(username)) {
						out.println("Yes");
					}
					else {
						out.println("No");
					}
				}
			}
			out.close();
			in.close();
			socket.close();

		} catch (

		IOException e) {
			e.printStackTrace();
		}
	}

	private String gradeSubmission(String fileName, int problem, String username) {
		int numberOfTests = 1;
		switch (ProblemSubmission.questionNumberToQuestionName(problem)) {
		case "HelloWorld":
			numberOfTests = 1;
			break;
		case "Strings":
			numberOfTests = 4;
			break;
		case "Doors":
			numberOfTests = 1;
			break;
		case "Recursion":
			numberOfTests = 8;
			break;
		case "Toaster":
			numberOfTests = 6;
			break;
		case "Lonely":
			numberOfTests = 3;
		}
		File[] filesToClear = new File(
				"..\\ProgComp\\" + username + "\\" + ProblemSubmission.questionNumberToQuestionName(problem))
						.listFiles();
		for (File x : filesToClear) {
			if(!x.getName().equals(ProblemSubmission.questionNumberToQuestionName(problem) + ".java"))
			x.delete();
		}
		for (int i = 1; i <= numberOfTests; i++) {
			File[] files = new File(
					"..\\ProgComp\\" + username + "\\" + ProblemSubmission.questionNumberToQuestionName(problem))
							.listFiles();
			for (File x : files) {
				if ( !x.getName().equals("Output.txt")
						&& !x.getName().equals(ProblemSubmission.questionNumberToQuestionName(problem) + ".java")) {
					x.delete();
				}
			}
			Process p = null;
			try {
				p = Runtime.getRuntime()
						.exec("cmd /c start ..\\ProgComp\\RunTests.bat " + "..\\ProgComp " + username + " "
								+ ProblemSubmission.questionNumberToQuestionName(problem) + " " + "OurPrograms\\"
								+ ProblemSubmission.questionNumberToQuestionName(problem) + "In" + i + ".txt");

			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (FileLoader.fileExists("..\\ProgComp\\" + username + "\\"
					+ ProblemSubmission.questionNumberToQuestionName(problem) + "\\Answer.txt")) {
				String[] answer = FileLoader.readFile("..\\ProgComp\\" + username + "\\"
						+ ProblemSubmission.questionNumberToQuestionName(problem) + "\\Answer.txt");
				if ( !answer[3].equals("0")) {
					if (answer[4].equals("Runtime Error")) {
						return "RuntimeError";
					}
					else if (answer[4].equals("Compile Error")) {
						return "CompileError";
					}
					else {
						return "Incorrect";
					}
				}
			}
			else {
				p.destroyForcibly();
				return "TimeoutError";
			}
		}

		return "Correct";
	}
}