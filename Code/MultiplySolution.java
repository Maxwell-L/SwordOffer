/*
 * 构建乘积数组
 * 题目描述:
 *     给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 *
 * 思路:
 *     直接每一位计算时间复杂度是O(n^2)，可通过构建辅助数组来降低复杂度。构建等长的数组C和D，C中元素C[i]=A[0]*A[1]*...*A[i]，
 * D中元素D[i] = A[i]*A[i+1]*...*A[n-1]，故可知B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]=C[i-1]*D[i+1]，再考虑边界情况
 * B[0]=D[1]，B[n-1]=C[n-2]，可构建出B，时间复杂度为O(n)。
 */
public class MultiplySolution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        int[] D = new int[A.length];
        C[0] = A[0];
        D[A.length - 1] = A[A.length - 1];
        for(int i = 1, j = A.length - 2; i < A.length; i++, j--) {
            C[i] = C[i-1] * A[i];
            D[j] = D[j+1] * A[j];
        }
        for(int i = 0; i < A.length; i++) {
            if(i == 0) {
                B[i] = D[i + 1];
            } else if(i == A.length - 1) {
                B[i] = C[i - 1];
            } else {
                B[i] = C[i - 1] * D[i + 1];
            }
        }
        return B;
    }
}

