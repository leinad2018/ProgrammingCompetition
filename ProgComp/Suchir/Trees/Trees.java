import java.util.Scanner;

public class Trees {
	public static void markOrthogonalSquares(int i, int j, int n, char[][] landscape, boolean[][] flagscape) {
		if ((i == 0 || flagscape[i - 1][j]) && (i == n - 1 || flagscape[i + 1][j]) && (j == 0 || flagscape[i][j - 1])
				&& (j == n - 1 || flagscape[i][j + 1]))
			return;
		if (i > 0 && landscape[i - 1][j] != 'X' && flagscape[i - 1][j] != true) {
			flagscape[i - 1][j] = true;
			markOrthogonalSquares(i - 1, j, n, landscape, flagscape);
		}
		if (i < n - 1 && landscape[i + 1][j] != 'X' && flagscape[i + 1][j] != true) {
			flagscape[i + 1][j] = true;
			markOrthogonalSquares(i + 1, j, n, landscape, flagscape);
		}
		if (j > 0 && landscape[i][j - 1] != 'X' && flagscape[i][j - 1] != true) {
			flagscape[i][j - 1] = true;
			markOrthogonalSquares(i, j - 1, n, landscape, flagscape);
		}
		if (j < n - 1 && landscape[i][j + 1] != 'X' && flagscape[i][j + 1] != true) {
			flagscape[i][j + 1] = true;
			markOrthogonalSquares(i, j + 1, n, landscape, flagscape);
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int loops = in.nextInt();
		for (int k = 0; k < loops; k++) {
			int n = in.nextInt();
			int boatRow = 0;
			int boatColumn = 0;
			int cayRow = 0;
			int cayColumn = 0;
			char[][] landscape = new char[n][n];
			boolean[][] flagscape = new boolean[n][n];
			in.nextLine();
			for (int i = 0; i < n; i++) {
				String line = in.nextLine();
				char[] characters = line.toCharArray();
				for (int j = 0; j < n; j++) {

					landscape[i][j] = characters[j];
					if (characters[j] == 'C') {
						cayRow = i;
						cayColumn = j;
					}
					if (characters[j] == 'B') {
						boatRow = i;
						boatColumn = j;
					}
				}
			}
			markOrthogonalSquares(cayRow, cayColumn, n, landscape, flagscape);
			if (flagscape[boatRow][boatColumn] == true)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		in.close();
	}
}
