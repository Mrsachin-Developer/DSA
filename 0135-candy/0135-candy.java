class Solution {
    public int candy(int[] ratings) {
        int n= ratings.length;
int[] candies= new int[n];

Arrays.fill(candies,1);


int left=0;

//left to right
for(int i=1;i<n;i++){
    if (ratings[i]>ratings[i-1]) {
        candies[i]=candies[i-1]+1;
    }
}


for(int i=n-2;i>=0;i--){
    if(ratings[i]>ratings[i+1]){
        candies[i]= Math.max(candies[i],candies[i+1]+1); // suppose the candies are same  1,1 and the rating of i is > i+1 so we need the i to be greater 
    }
}

int total=0;

for(int c:candies){
    total+=c;
}

return total;
    }
}