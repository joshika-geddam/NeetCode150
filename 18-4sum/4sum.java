class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
            for(int i=0;i<nums.length;i++){
                for(int p=i+1;p<nums.length;p++){
                    int j=p+1;
                    int k=nums.length-1;
                    while(j<k){
                        long sum=(long)nums[i]+nums[p]+nums[j]+nums[k];
                        if(sum==target){
                            set.add(Arrays.asList(nums[i],nums[p],nums[j],nums[k]));
                            j++;
                            k--;
                        }
                        else if(sum<target){
                            j++;
                        }
                        else{
                            k--;
                        }
                    }
                }
            }
        return new ArrayList<>(set);
    }
}