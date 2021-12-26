class Node {
    public char val;
    public boolean isWord; 
    public Node[] children = new Node[26];
    
    public Node() {}
    
    Node(char c){
        Node node = new Node();
        node.val = c;
    }
}

class Trie {
    private Node root;
    
    public Trie() {
        root = new Node();
        root.val = ' ';
    }
    
    public void insert(String word) {
        Node before = root;
        for (char c : word.toCharArray()) {
            if (before.children[c - 'a'] == null) {
                before.children[c - 'a'] = new Node(c);
            }
            before = before.children[c - 'a'];
        }
        before.isWord = true;
    }
    
    public boolean search(String word) {
        Node before = root;
        for (char c : word.toCharArray()) {
            if (before.children[c - 'a'] == null) {
                return false;
            }
            before = before.children[c - 'a'];
        }
        return before.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node before = root;
        for (char c : prefix.toCharArray()) {
            if (before.children[c - 'a'] == null) {
                return false;
            }
            before = before.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */