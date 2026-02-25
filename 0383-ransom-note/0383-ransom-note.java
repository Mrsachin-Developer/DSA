import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();

        int mag = magazine.length();
        int ran = ransomNote.length();

  
        for (int i = 0; i < mag; i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

   
        for (int i = 0; i < ran; i++) {
            char ch = ransomNote.charAt(i);

            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }

            map.put(ch, map.get(ch) - 1);
        }

        return true;
    }
}