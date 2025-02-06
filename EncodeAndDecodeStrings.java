class Solution {
    final char delimiter='#';
    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            sb.append(str.length());
            sb.append(delimiter);
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result=new ArrayList<>();
        char[] ch=str.toCharArray();
        for(int i=0;i<ch.length;i++){
            StringBuilder sb=new StringBuilder();
            while(ch[i]!=delimiter){
                sb.append(ch[i++]);
            }
            i++;
            int num=Integer.valueOf(sb.toString());
            int end=num+i;
            sb=new StringBuilder();
            while(i<end){
                sb.append(ch[i++]);
            }
            i--;
            result.add(sb.toString());
        }
        return result;
    }
}
