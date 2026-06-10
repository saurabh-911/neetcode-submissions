class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        double[][] a = new double[n][2];

        for(int i=0; i<n; i++){
            a[i][0] = position[i];
            a[i][1] = ((double) target - position[i] ) / speed[i];
        }

        Arrays.sort(a, (x, y) -> Double.compare(x[0], y[0]));

        int carFleet = 0;
        double prev = 0.0;
        for(int i = n-1; i>=0; i--){
            double curr = a[i][1];
            if(curr > prev){
                carFleet++;
                prev = curr;
            }
        }
        return carFleet;
    }
}
