class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result,current,0,nums);
        return result;  
    }
    public void backtrack(List<List<Integer>> result,List<Integer> current,int start,int[] nums){
        result.add(new ArrayList<>(current));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            current.add(nums[i]);
            backtrack(result,current,i+1,nums);
            current.remove(current.size()-1);
        }
    }
}