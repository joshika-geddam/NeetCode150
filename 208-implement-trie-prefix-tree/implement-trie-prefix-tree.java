public class TrieNode{
    HashMap<Character,TrieNode> children;
    boolean endOfWord;
    public TrieNode(){
        this.children=new HashMap<>();
        this.endOfWord=false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current=root;
        for(char c:word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.putIfAbsent(c,new TrieNode());
            }
            current=current.children.get(c);
        }
        current.endOfWord=true;
        
    }
    
    public boolean search(String word) {
        TrieNode current=root;
        for(char c:word.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            }
            current=current.children.get(c);
        }
        return current.endOfWord;


        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current=root;
        for(char c:prefix.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            }
            current=current.children.get(c);
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