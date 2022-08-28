package 华为机考;

import org.junit.Test;

public class Test8 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int posX, int posY) {
        if (posX < 0 || posY < 0 || posX >= grid.length || posY >= grid[0].length) return 0;
        if (grid[posX][posY] == 0) return 0;
        grid[posX][posY] = 0;
        int res = 1;
        res += dfs(grid, posX + 1, posY);
        res += dfs(grid, posX - 1, posY);
        res += dfs(grid, posX, posY + 1);
        res += dfs(grid, posX, posY - 1);
        return res;
    }

    int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int getMaximumGold(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                res = Math.max(res, getGold(grid, i, j));
            }
        }
        return res;
    }

    public int getGold(int[][] grid, int posX, int posY) {
        if (posX < 0 || posY < 0 || posX >= grid.length || posY >= grid[0].length) return 0;
        if (grid[posX][posY] == 0) return 0;
        int tmp = grid[posX][posY];
        int res = 0;
        grid[posX][posY] = 0;
        for (int i = 0; i < 4; i++) {
            int x = posX + direction[i][0];
            int y = posY + direction[i][1];
            res = Math.max(res, getGold(grid, x, y));
        }
        grid[posX][posY] = tmp;
        return res + tmp;
    }

    @Test
    public void test() {
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(getMaximumGold(grid));
    }
}
