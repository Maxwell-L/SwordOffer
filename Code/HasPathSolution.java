/*
 * 矩阵中的路径
 * 题目描述:
 *     请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开
 * 始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入
 * 该格子。例如[a b c e; s f c s; a d e e]矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符
 * 串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 思路:
 *     1、主函数找到第一个字符匹配的，进入辅助函数。
 *     2、按照上下左右分别判断，若与下一个字符相同则设置 visit 为 1，进入下一层迭代。
 */
public class HasPathSolution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(str == null || str.length == 0) {
            return false;
        }
        char[][] m = new char[rows][cols];
        int k = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                m[i][j] = matrix[k++];
            }
        }
        boolean[][] visit = new boolean[rows][cols];
        boolean res = false;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(m[i][j] == str[0]) {
                    visit[i][j] = true;
                    res = hasPathHelp(m, visit, str, 1, i, j);
                    visit[i][j] = false;
                    if(res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean hasPathHelp(char[][] matrix, boolean[][] visit, char[] str, int index, int r, int c) {
        if(index == str.length) {
            return true;
        }
        boolean flag = false;
        if(r > 0 && matrix[r - 1][c] == str[index] && visit[r - 1][c] == false) {
            visit[r - 1][c] = true;
            flag = hasPathHelp(matrix, visit, str, index + 1, r - 1, c);
            if(flag) {
                return true;
            }
            visit[r - 1][c] = false;
        }
        if(r < matrix.length - 1 && matrix[r + 1][c] == str[index] && visit[r + 1][c] == false) {
            visit[r + 1][c] = true;
            flag = hasPathHelp(matrix, visit, str, index + 1, r + 1, c);
            if(flag) {
                return true;
            }
            visit[r + 1][c] = false;
        }
        if(c > 0 && matrix[r][c - 1] == str[index] && visit[r][c - 1] == false) {
            visit[r][c - 1] = true;
            flag = hasPathHelp(matrix, visit, str, index + 1, r, c - 1);
            if(flag) {
                return true;
            }
            visit[r][c - 1] = false;
        }
        if(c < matrix[0].length - 1 && matrix[r][c + 1] == str[index] && visit[r][c + 1] == false) {
            visit[r][c + 1] = true;
            flag = hasPathHelp(matrix, visit, str, index + 1, r, c + 1);
            if(flag) {
                return true;
            }
            visit[r][c + 1] = false;
        }
        return false;
    }
}