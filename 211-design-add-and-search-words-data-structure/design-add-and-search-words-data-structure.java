public class TrieNode{
    TrieNode children[];
    boolean endOfWord;
    public TrieNode(){
        this.children=new TrieNode[26];
        this.endOfWord=false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current=root;
        for(char c:word.toCharArray()){
            if(current.children[c-'a']==null){
                current.children[c-'a']=new TrieNode();
            }
            current=current.children[c-'a'];
        }
        current.endOfWord=true;
        
    }
    
    public boolean search(String word) {
        return dfs(root,0,word);
    }
    public boolean dfs(TrieNode root,int j,String word){
        TrieNode current=root;
        for(int i=j;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(TrieNode child:current.children){
                    if(child!=null && dfs(child,i+1,word)){
                        return true;
                    }
                }
                return false;
            }
            else{
                if(current.children[c-'a']==null){
                    return false;
                }
                 current=current.children[c-'a'];
            }
        }
        return current.endOfWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */