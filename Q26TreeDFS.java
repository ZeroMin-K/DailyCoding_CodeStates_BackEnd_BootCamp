import java.util.*;

public class Q26TreeDFS {
    public ArrayList<String> dfs(tree node) {

        // 탐색 노드 넣을 ArrayList 생성
        ArrayList<String> values = new ArrayList<>();
        // 현재 노드 데이터 ArrayList에 추가
        values.add(node.getValue());

        // 현재 노드와 연결된 자식 노드가 있으면
        if(node.getChildrenNode() != null) {
            // 연결된 자식 노드 만큼
            for(int i = 0; i < node.getChildrenNode().size(); i++) {
                // 자식노드들에 대해 dfs를 진행 후 탐색해서 넣은 데이터를 curList로 반환
                ArrayList<String> curList = dfs(node.getChildrenNode().get(i));
                // curList의 데이터를 탐색노드 ArrayList values에 모두 추가
                values.addAll(curList);
            }
        }
        return values;
    }

    public static class tree {
        private String value;

        // 자식 노드 - ArrayList
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        // 자식 노드 추가
        public tree addChildNode(tree node) {
            // 자식 노드가 없으면
            if(children == null)
                // 자식 노드 생성
                children = new ArrayList<>();

            // 자식노드 ArrayList의 추가된 마지막 노드 반환
            return children.get(children.size() -1);
        }

        // 현재 노드 데이터 반환
        public String getValue() {
            return value;
        }

        // 자식 노드 반환
        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}
