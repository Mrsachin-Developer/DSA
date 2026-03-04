class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap <Character,Integer> map = new HashMap<>();

        int n=s.length();
if (s.length() != t.length()) {
    return false;
}
        for(int i=0;i<n;i++){
            char ch =s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
    
        for(int i=0;i<t.length();i++){
            char ch =t.charAt(i);
          if(!map.containsKey(ch)){
            return false;
          }
          map.put(ch,map.get(ch)-1);
          if(map.get(ch)==0){
            map.remove(ch);
          }
        }
        return true;
    }
}