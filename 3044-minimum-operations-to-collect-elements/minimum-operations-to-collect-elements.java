class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int size = nums.size();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= k; i++){
            set.add(i);
        }
        
        int minOperations = 0;
        int index = size - 1;
        while(!set.isEmpty() && index >= 0){
            int num = nums.get(index);
            if(set.contains(num)){
                set.remove(num);
            }
            minOperations++;
            index--;
        }

        return minOperations;
    }
}