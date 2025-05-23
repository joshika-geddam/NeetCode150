class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits.isEmpty()){
            return result;
        }
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrack(digits,result,map,"",0);
        return result;
    }
    public void backtrack(String digits,List<String> result,HashMap<Character,String> map,String current,int index){
        if(index==digits.length()){
            result.add(current);
            return;
        }
        for(char c:map.get(digits.charAt(index)).toCharArray()){
            backtrack(digits,result,map,current+c,index+1);
        }
    }
}