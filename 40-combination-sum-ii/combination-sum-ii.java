class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result,current,0,nums,target);
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> current,int index,int[] nums,int target){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(current));
        }
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            current.add(nums[i]);
            backtrack(result,current,i+1,nums,target-nums[i]);
            current.remove(current.size()-1);
        }
    }
}