import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q27treeBFS {

    // BFS
    public ArrayList<String> bfs(tree node) {

        // 큐 생성
        Queue<tree> queue = new LinkedList<>();

        // 탐색한 노드 저장할 ArrayList 생성
        ArrayList<String> arrayList = new ArrayList<>();

        // 큐에 현재 탐색 시작하는 노드 삽입
        queue.add(node);

        // 큐가 빌 때까지
        while( queue.size() > 0 ) {
            // 큐에서 deque하여 현재 커서 노드 curNode에 할당
            tree curNode = queue.poll();

            // 현재 curNode의 값을 가져와서 arrayList에 저장
            arrayList.add(curNode.getValue());

            // 현재 curNode에 자식 노드가 있으면
            if (curNode.getChildrenNode() != null) {
                // curNode의 자식노드들을 queue에 전부 삽입
                queue.addAll(curNode.getChildrenNode());
            }
        }

        return arrayList;
    }

    public static class tree {
        // 현재 노드의 값
        private String value;
        // 자식 노드 ArrayList
        private ArrayList<tree> children;

        // tree 초기화
        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        // 현재 노드에 자식 노드 추가
        public tree addChildNode(tree node) {
            // 자식 노드가 없으면
            if(children == null)
                // 자식 노드 arrayList 생성
                children = new ArrayList<>();

            // 자식노드 ArrayList에 현재 자식 노드 추가
            children.add(node);

            // 방금 추가한 자식노드 반환
            // 자식노드 ArrayList에서 가장 마지막 원소
            return children.get(children.size() -1);
        }

        // 현재 노드 데이터 반환
        public String getValue() {
            return value;
        }

        // 현재 노드의 자식노드 ArrayList 반환
        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}
