import java.util.Scanner;

public class Trees {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int numberOfTestCases=s.nextInt();
		for (int testCase=0; testCase<numberOfTestCases; testCase++) {
			int size=s.nextInt();
			s.nextLine();
			int startX=0, startY=0, endX=0, endY=0;
			boolean[][] board=new boolean[size][size];
			boolean[][] reachable=new boolean[size][size];
			
			for (int y=0; y<size; y++) {
				String line=s.nextLine();
				for (int x=0; x<size; x++) {
					reachable[x][y]=false;
					
					if (line.charAt(x)=='X') {
						board[x][y]=false;
					}
					else if (line.charAt(x)=='.') {
						board[x][y]=true;
					}
					else if (line.charAt(x)=='B') {
						endX=x;
						endY=y;
						board[x][y]=true;
					}
					else {
						startX=x;
						startY=y;
						board[x][y]=true;
					}
				}
			}
			
			travel(board, reachable, startX, startY);
			
			if (reachable[endX][endY]) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}

	}

	private static void travel(boolean[][] board, boolean[][] reachable, int x, int y) {
		if (x<0||y<0||x>=board.length||y>=board[0].length||!board[x][y]||reachable[x][y]) {
			return;
		}
		reachable[x][y]=true;
		travel(board, reachable, x-1, y);
		travel(board, reachable, x+1, y);
		travel(board, reachable, x, y-1);
		travel(board, reachable, x, y+1);
	}
	
}
