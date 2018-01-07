package algo;

//463
public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] island = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		islandPerimeter(island);
	}

	public static int islandPerimeter(int[][] grid) {
		int total = 0;
		// row count
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1)
					total += 4;
			}
		}
		// col count
		int rep = 0;
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid.length; j++) {
				// compare down
				if (j == grid.length - 1) {
				} else if (grid[j][i] * grid[j + 1][i] == 1)
					rep++;
				// compare left
				if (i == 0) {
				} else if (grid[j][i] * grid[j][i - 1] == 1)
					rep++;
			}
		}
		return total - 2 * rep;
	}

}
