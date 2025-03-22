class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] table=new boolean[s.length()];
        for(int i=0;i<table.length;i++){
            for(int y=0;y<=i;y++){
                if(y==0||table[y-1]){
                    if(wordDict.contains(s.substring(y,i+1))){
                        table[i]=true;
                        break;
                    }
                }
            }
        }
        return table[table.length-1];
    }
}