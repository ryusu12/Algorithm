class Solution {
    public int primeNum(int num) {
        for (int i = 2; i < num; i++) {
            if(num % i == 0) return 0;
        }
        return 1;
    }
    
    public int solution(int[] nums) {
        int answer = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    answer += primeNum(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        return answer;
    }
}