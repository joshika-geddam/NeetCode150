class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        List<String> result=new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrack(result,map,digits,0,"");
        return result;
    }
    public void backtrack(List<String> result,HashMap<Character,String> map,String digits,int index,String current){
        if(index==digits.length()){
            result.add((current));
            return;
        }
        for(char c:map.get(digits.charAt(index)).toCharArray()){
            backtrack(result,map,digits,index+1,current+c);
        }
    }
}