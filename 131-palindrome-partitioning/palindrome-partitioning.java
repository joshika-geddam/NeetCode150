class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> current=new ArrayList<>();
        backtrack(result,current,0,s);
        return result;
    }
    public void backtrack(List<List<String>> result,List<String> current,int index,String s){
        if(index==s.length()){
            result.add(new ArrayList<>(current));
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(index,i,s)){
                current.add(s.substring(index,i+1));
                backtrack(result,current,i+1,s);
                current.remove(current.size()-1);
            }
        }
    }
    public boolean isPalindrome(int left,int right,String s){
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