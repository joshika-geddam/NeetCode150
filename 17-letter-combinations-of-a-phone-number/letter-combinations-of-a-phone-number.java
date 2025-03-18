class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits.isEmpty()){
            return list;
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
        backtrack(0,"",digits,map,list);
        return list;
    }
    public void backtrack(int index,String current,String digits,HashMap<Character,String> map,List<String> list){
        if(current.length()==digits.length()){
            list.add(current);
            return;
        }
        for(char c:map.get(digits.charAt(index)).toCharArray()){
            backtrack(index+1,current+c,digits,map,list);
        }
    }
}