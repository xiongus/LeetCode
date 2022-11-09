import java.util.Arrays;

public class Solution_733 {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        System.out.println(Arrays.deepToString(new Solution_733().floodFill(image, sr, sc, color)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int val, int color) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return;
        }
        if (val != image[sr][sc]) {
            return;
        }
        image[sr][sc] = color;
        dfs(image, sr + 1, sc, val, color);
        dfs(image, sr - 1, sc, val, color);
        dfs(image, sr, sc + 1, val, color);
        dfs(image, sr, sc - 1, val, color);

    }

    private void top(int[][] image, int row, int col, int val, int color) {
        if (row < 0 || row > image.length - 1 || image[row][col] != val) {
            return;
        }
        top(image, row - 1, col, val, color);
        image[row][col] = color;
    }

    private void down(int[][] image, int row, int col, int val, int color) {
        if (row < 0 || row > image.length - 1 || image[row][col] != val) {
            return;
        }
        down(image, row + 1, col, val, color);
        image[row][col] = color;
    }

    private void left(int[][] image, int row, int col, int val, int color) {
        if (col < 0 || col > image[row].length - 1 || image[row][col] != val) {
            return;
        }
        left(image, row, col - 1, val, color);
        image[row][col] = color;
    }

    private void right(int[][] image, int row, int col, int val, int color) {
        if (col < 0 || col > image[row].length - 1 || image[row][col] != val) {
            return;
        }
        left(image, row, col + 1, val, color);
        image[row][col] = color;
    }


    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        int val = image[sr][sc];
        // sr --> last index
        for (int i = sr; i < image.length; i++) {
            // sc --> 0
            for (int j = sc; j >= 0; j--) {
                if (image[i][j] != val) {
                    break;
                }
                image[i][j] = color;
            }
            // sc + 1 --> last index
            if (image[i][sc] == color) {
                for (int j = sc + 1; j < image[i].length; j++) {
                    if (image[i][j] != val) {
                        break;
                    }
                    image[i][j] = color;
                }
            }
        }
        // sr --> first index
        for (int i = sr; i >= 0; i--) {
            // sc --> 0
            for (int j = sc; j >= 0; j--) {
                if (image[i][j] != val) {
                    break;
                }
                image[i][j] = color;
            }
            if (image[i][sc] == color) {
                // sc + 1 --> last index
                for (int j = sc + 1; j < image[i].length; j++) {
                    if (image[i][j] != val) {
                        break;
                    }
                    image[i][j] = color;
                }
            }
        }
        image[sr][sc] = color;
        return image;
    }
}
