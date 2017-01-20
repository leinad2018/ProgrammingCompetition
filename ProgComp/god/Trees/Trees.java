import java.util.Scanner;

public class Trees {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int grids = in.nextInt();
		int boatRow = 0;
		int boatColumn = 0;
		int cayRow = 0;
		int cayColumn = 0;
		for (int i = 0; i < grids; i++) {
			int side = in.nextInt();
			char[][] grid = new char[side][side];
			for (int r = 0; r < side; r++) {
				String curRow = in.nextLine();
				while (curRow.equals(" ") || curRow.equals("")) {
					curRow = in.nextLine();
				}
				char[] characters = curRow.toCharArray();
				for (int c = 0; c < side; c++) {
					grid[r][c] = characters[c];
					if (characters[c] == 'C') {
						cayRow = r;
						cayColumn = c;
					}
					if (characters[c] == 'B') {
						boatRow = r;
						boatColumn = c;
					}
				}
			}
			convert(grid, cayRow, cayColumn);
			if (grid[boatRow][boatColumn] == 'C') {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	public static void convert(char[][] grid, int targetRow, int targetColumn) {
		// Top
		if (targetRow > 0) {
			int topRow = targetRow - 1;
			if (grid[topRow][targetColumn] == '.' || grid[topRow][targetColumn] == 'B') {
				grid[topRow][targetColumn] = 'C';
				convert(grid, topRow, targetColumn);
			}
		}

		// Right
		if (targetColumn < grid[0].length - 1) {
			int rightColumn = targetColumn + 1;
			if (grid[targetRow][rightColumn] == '.' || grid[targetRow][rightColumn] == 'B') {
				grid[targetRow][rightColumn] = 'C';
				convert(grid, targetRow, rightColumn);
			}
		}

		// Bottom
		if (targetRow < grid.length - 1) {
			int bottomRow = targetRow + 1;
			if (grid[bottomRow][targetColumn] == '.' || grid[bottomRow][targetColumn] == 'B') {
				grid[bottomRow][targetColumn] = 'C';
				convert(grid, bottomRow, targetColumn);
			}
		}

		// Left
		if (targetColumn > 0) {
			int leftColumn = targetColumn - 1;
			if (grid[targetRow][leftColumn] == '.' || grid[targetRow][leftColumn] == 'B') {
				grid[targetRow][leftColumn] = 'C';
				convert(grid, targetRow, leftColumn);
			}
		}
	}
}
