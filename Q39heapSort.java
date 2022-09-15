import java.util.PriorityQueue;

public class Q39heapSort {
    public int[] heapSort(int[] arr) {

        // 힙 정렬에 사용할 힙(우선순위 큐) 선언
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        // 힙에 배열 값 모두 할당
        for(int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        // 힙에서 우선순위가 가장 높은 원소 (root노드)를 배열에 넣음
        for(int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }

        return arr;
    }
}
