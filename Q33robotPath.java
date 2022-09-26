public class Q33robotPath {
    public int robotPathRef(int[][] room, int[] src, int[] dst) {

        /*
            로봇의 현재 위치를 0에서 1로 초기화 => 다시 방문하지 않게 많듬
            바로 옆 통로는 2가됨.
            계산이 완료되면 최종값에 1을 빼줌
         */
        room = dfsRef(room.length, room[0].length, src, 1, room);

        return room[dst[0]][dst[1]] - 1;

    }
    /*
    dfs
    방을 상, 하, 좌, 우 탐색하면서 갈 수 있으면 몇번째 방문하는지 체크하면서 진행
    @ m: 방의 행 수
    @ n: 방의 열 수
    @ loc: 현재 로봇의 위치 [row, col]
    @ step: 현재 방까지 도착하는데 걸린 시간
        - 처음 시작할 때 1부터 시작(시작한 방도 다시 방문하지 않게 만듬)
    @ room: 방 배열
     */
    public int[][] dfsRef(int m, int n, int[] loc, int step, int[][] room){

        // 현재 위치
        int row = loc[0];
        int col = loc[1];

        // 배열 범위를 벗어나면
        if (row < 0 || row >= m || col < 0 || col >= n)
            return room;

        // 방문하지 않은 곳이거나 최소시간보다 더 오래 걸린 방이면
        if(room[row][col] == 0 || room[row][col] > step) {
            room[row][col] = step;
        } else {
            // 장애물(1)이거나 이미 최소 시간으로 통과가 가능한 경우
            return room;
        }

        // dfs로 4가지 방향 탐색
        // 완전 탐색 해야하므로 bfs, dfs 차이없음
        // bfs의 경우 목적지에 도착하는 경우 탐색 중단 => 약간 더 효율적
        dfsRef(m, n, new int[]{row + 1, col}, step + 1, room);     // 위로 탐색
        dfsRef(m, n, new int[]{row - 1, col}, step+ 1, room);       // 아래로 탐색
        dfsRef(m, n, new int[]{row, col -1 }, step + 1, room);      // 왼쪽으로 탐색
        dfsRef(m, n, new int[]{row, col + 1}, step + 1, room);     // 오른쪽으로 탐색

        return room;
    }
}