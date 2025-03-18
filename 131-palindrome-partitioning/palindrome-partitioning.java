class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> current=new ArrayList<>();
        dfs(s,0,current);
        return result;
    }
    public void dfs(String s,int index,List<String> current){
        if(index==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                current.add(s.substring(index,i+1));
                dfs(s,i+1,current);
                current.remove(current.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}