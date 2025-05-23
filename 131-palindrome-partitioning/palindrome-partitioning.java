class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> current=new ArrayList<>();
        backtrack(result,current,s,0);
        return result;
    }
    public void backtrack(List<List<String>> result,List<String> current,String s,int index){
        if(index==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                current.add(s.substring(index,i+1));
                backtrack(result,current,s,i+1);
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