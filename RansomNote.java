class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        //return firstVersion(ransomNote, magazine);
        //return secondVersion(ransomNote, magazine);
        return thirdVersion(ransomNote, magazine);

    }
    
    private boolean firstVersion(String ransomNote, String magazine) {
        int[] alphaFreqMap = new int[26];
        //calculate and build alphabets frequency map of magazine
        for (char ch : magazine.toCharArray()) 
            alphaFreqMap[ch - 97]++;
        
        for (char ch : ransomNote.toCharArray()) {
           if (alphaFreqMap[ch - 97] > 0) alphaFreqMap[ch - 97]--;
           else return false;
        }
        return true;
    }
    
    private boolean secondVersion(String ransomNote, String magazine) {
        int[] alphaFreqMap = new int[26];
        int ransomLen = ransomNote.length();
        for (char ch : ransomNote.toCharArray()){
            alphaFreqMap[ch - 'a']++;
        }
        
        for (char ch : magazine.toCharArray()) {
            int index = ch - 'a';
            if (alphaFreqMap[index] != 0) {
                alphaFreqMap[index]--;
                ransomLen--;
            }
        }
        return ransomLen == 0 ? true : false;
    }
    /**
      *Here for every ransom character we are finding its next character index possible in magazine,
      *if it is possible then return true otherwise false.
      *This is more efficient with complexity and less operation O(len(magazine))
      */
    private boolean thirdVersion(String ransomNote, String magazine) {
        int[] nextCharIndices = new int[26];
        for (char ch : ransomNote.toCharArray()) {
            int index = magazine.indexOf(ch, nextCharIndices[ch - 'a']);
            if (index == -1) return false;
            else nextCharIndices[ch - 'a'] = index + 1;
        }
        return true;
    }
}
// Testcases
/*
"a"
"b"
"ahfahdfa"
"ajshf"
"asvvadg"
"avvd"
"avdhesh"
"esdhh"
"esdhh"
"avdhesh"
""
"kashf"
""
""
"adsf"
""
*/