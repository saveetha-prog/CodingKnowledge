class Solution {
    public double[] convertTemperature(double celsius) {
        double kelvin=0;
        double Far=0;
        kelvin=celsius+273.15;
        Far=(celsius*1.80)+32.00;
        double[] ans=new double[2];
        ans[0]=kelvin;
        ans[1]=Far;
        return ans;
    }
}