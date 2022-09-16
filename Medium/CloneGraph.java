/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    public Node cloneGraph(Node node) {
        if(node == null                )
            return null;
        Node[] vis = new Node[101];
        Node newNode = new Node(node.val);
        vis[node.val] = newNode;
        for(Node i : node.neighbors) {
            if(vis[i.val] == null) newNode.neighbors.add(dfs(i, vis));
            else newNode.neighbors.add(vis[i.val]);
        }
        return newNode;
    }
    
    private Node dfs(Node node, Node[] vis) {
        Node newNode = new Node(node.val);
        vis[node.val] = newNode;
        for(Node i : node.neighbors) {
            if(vis[i.val] == null) newNode.neighbors.add(dfs(i, vis));
            else newNode.neighbors.add(vis[i.val]);
        }
        return newNode;
    }
}
