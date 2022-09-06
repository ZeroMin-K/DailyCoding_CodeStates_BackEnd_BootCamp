public class Q34rotateMatrix {
    public int[][] rotateMatrixRef(int[][] matrix, int K) {
        // 빈 배열일 경우
        if(matrix == null || matrix.length == 0)
            // 그대로 리턴
            return matrix;

        // 2차원 배열의 행
        int n = matrix.length;
        // 2차원 배열의 열
        int m = matrix[0].length;

        // 회전횟수에서 4로 나눈 나머지 값을 저장
        int rotateNum = K % 4;

        // 4번 회전하면 자기자신. 회전횟수에서 4로 나누어지면
        if(rotateNum == 0)
            // 그대로 자기 자신 리턴
            return matrix;

        // 회전된 배열 - 홀수번 회전시 m * n, 짝수번 회전시 n * m
        int[][] rotatedMatrix = rotateNum % 2 == 1 ? new int[m][n] : new int[n][m];

        // 회전된 배열 행만큼 반복하며
        for(int row = 0; row < rotatedMatrix.length; row++) {
            // 회전된 배열 열만큼 반복하며
            for(int col = 0; col < rotatedMatrix[row].length; col++) {
                // 한번 회전하면
                if(rotateNum == 1) {
                    rotatedMatrix[row][col] = matrix[n - col -1][row];
                } else if(rotateNum == 2) {         // 두번 회전하면
                    rotatedMatrix[row][col] = matrix[n - row -1][m - col -1];
                } else {                            // 세번 회전하면
                    rotatedMatrix[row][col] = matrix[col][m - row -1];
                }
            }
        }
        return rotatedMatrix;
    }
}
