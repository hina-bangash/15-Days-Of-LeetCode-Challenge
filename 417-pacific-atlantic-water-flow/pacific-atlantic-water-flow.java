class Solution {
    private int m, n;
    private int[][] heights;
    private boolean[][] pacific;
    private boolean[][] atlantic;

    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;

        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];

        // Start DFS from Pacific border
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);      // left edge
            dfs(i, n - 1, atlantic); // right edge
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific);      // top edge
            dfs(m - 1, j, atlantic); // bottom edge
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] visited) {
        if (visited[r][c]) return;
        visited[r][c] = true;

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            // Stay inside grid + only climb UP
            if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                heights[nr][nc] >= heights[r][c]) {

                dfs(nr, nc, visited);
            }
        }
    }
}
