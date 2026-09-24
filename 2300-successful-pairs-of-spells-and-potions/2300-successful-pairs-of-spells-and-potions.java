
//spell* potion>=sucess
// find a potion <=sucess/spell

class Solution {

    public int possiblePotions(int spell, int[] potions, long success) {

        long target = (long) Math.ceil((double) success / spell);

        int low = 0;
        int high = potions.length - 1;
        int ans = potions.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (potions[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return potions.length - ans;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);

        int[] ans = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {

            ans[i] = possiblePotions(
                    spells[i],
                    potions,
                    success);
        }

        return ans;
    }
}
