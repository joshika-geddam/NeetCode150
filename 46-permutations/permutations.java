class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        backtrack(result,current,nums);
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> current,int[] nums){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
        }
        for(int i=0;i<nums.length;i++){
            if(current.contains(nums[i])){
                continue;
            }
            current.add(nums[i]);
            backtrack(result,current,nums);
            current.remove(current.size()-1);
        }
    }
}