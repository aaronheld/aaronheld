class Main {
  public static void main(String[] args) {
  //  int[][] items = new int[][] {{2,2,3},{6,10,12}};
    int[] weight = new int [] {2,3,4,2,3};
    int[] value = new int[] {6,10,2,15,12};
    System.out.println(dynamicMaxVal(weight, value,5,0));
    System.out.println(maxVal(weight, value, 5, 0));
  }
  public static int maxVal(int[] weights, int[] vals, int maxWeight, int startIndex) {
    if(startIndex >= vals.length){
     return 0; 
    }
    if(weights[startIndex] > maxWeight) {
      
      return maxVal(weights, vals, maxWeight, startIndex +1); 
    }
    if(vals[startIndex] + maxVal(weights, vals, maxWeight - weights[startIndex], startIndex + 1) > maxVal(weights, vals, maxWeight, startIndex +1)){
      return vals[startIndex] + maxVal(weights, vals, maxWeight - weights[startIndex], startIndex+1);
    }
    else{
      return maxVal(weights, vals, maxWeight, startIndex +1);
    }
  }
  public static int dynamicMaxVal(int[] weights, int[] vals, int maxWeight, int endIndex) {
    int[][] maxVals = new int[weights.length + 1][maxWeight + 1];
    maxVals[0] = new int[maxWeight+1];
    for(int i = 1; i < maxVals.length; i++) {
      for(int j = 0; j <= maxWeight; j++){
        int curWeight = weights[i-1];
        if(curWeight > j) {
          maxVals[i][j] = maxVals[i-1][j];
        }
        else if(vals[i-1] + maxVals[i-1][j-curWeight] > maxVals[i-1][j]) {
          maxVals[i][j] = vals[i-1] + maxVals[i-1][j-curWeight];
        }
        else{maxVals[i][j] = maxVals[i-1][j];}
      }
    }
    return maxVals[weights.length][maxWeight];
  }

}
