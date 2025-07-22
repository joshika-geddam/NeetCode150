class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int num:nums){
        int pos=Collections.binarySearch(list,num);
        if(pos<0){
            pos=-(pos+1);
        }
        if(list.size()==pos){
            list.add(num);

        }
        list.set(pos,num);
        }
        return list.size();
    }
}