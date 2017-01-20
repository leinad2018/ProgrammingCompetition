import java.util.ArrayDeque;
import java.util.Scanner;

public class Trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			char[][] grid = new char[n][n];
			int startx = 0;
			int starty = 0;
			for (int i = 0; i < n; i++) {
				String s = in.next();
				for (int j = 0; j < n; j++) {
					grid[i][j] = s.charAt(j);
					if (grid[i][j] == 'C') {
						starty = i;
						startx = j;
					}
				}
			}
			ArrayDeque<Integer> moves = new ArrayDeque<Integer>();
			moves.add(starty);
			moves.add(startx);
			boolean found = false;
			int[]dx = {-1,1,0,0};
			int[] dy = {0,0,1,-1};
			while(!moves.isEmpty()){
				int y = moves.pollFirst();
				int x = moves.pollFirst();
				for(int i = 0; i < 4; i++){
					int yy = y+dy[i];
					int xx = x+dx[i];
					if(yy<0||xx<0||yy>=n||xx>=n)continue;
					if(grid[yy][xx]=='X')continue;
					if(grid[yy][xx]=='B'){
						found = true;
					}
					grid[yy][xx]='X';
					moves.add(yy);
					moves.add(xx);
				}
			}
			if(found){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}

}
