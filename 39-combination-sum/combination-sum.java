class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        backtrack(result,current,0,nums,target);
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> current,
    int index,int[] nums,int target){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);
            backtrack(result,current,i,nums,target-nums[i]);
            current.remove(current.size()-1);
        }
    }
}