/*
https://leetcode.com/problems/majority-element/
*/
class Solution {
    public int majorityElement(int[] nums) {
        //return firstVersion(nums);
        return secondVersion(nums);
    }
    
    /*
     * simple frequency count approach where anyelement has freq more than 
     * threshold (no of elemets/ 2) is the majority element
     */   
    private int firstVerion(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int val = 1;
            if (map.containsKey(num)) val = map.get(num) + 1;
            map.put(num, val);
        }
        
        int half = (int) Math.floor(nums.length / 2);
        int theElement = nums[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > half) {
                theElement = entry.getKey() ;
                break;
            }
        }
        return theElement;
    }
    
    /*
     * The Moore Voting Algorithm where compare with all elements if they are same increments otherwise
     * decrements and keep track of the leader index.
     *
     */
    private int secondVersion(int[] nums) {
        int countFreq = 1;
        int theMEleIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[theMEleIndex] == nums[i]) countFreq++; //people are same then increments votes
            else {
                countFreq--;  // otherwise decrements
                if (countFreq == 0) { //the votes are zero then nobody is the leader found yet.
                    countFreq = 1;
                    theMEleIndex = ++i;// now start searching from next element with the next to next element
                }
            }
        }
        return nums[theMEleIndex];
    }
}









/*
[3,2,3]
[1,2,3,1,4,1,5,1,1]
[1,1,1,1,1,3,4,5]
[1,2,3,1,1]
[1,2,2,1,1]

*/