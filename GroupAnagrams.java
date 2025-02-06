class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String freq=String.valueOf(ch);
            if(map.containsKey(freq)){
                map.get(freq).add(str);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(str);
                map.put(freq,list);
            }
        }
        return new ArrayList<>(map.values());
        
    }
}
