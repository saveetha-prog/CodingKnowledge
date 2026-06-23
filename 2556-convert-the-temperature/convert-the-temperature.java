class Solution {
    public double[] convertTemperature(double celsius) {
        double kelvin=0;
        double Far=0;
        kelvin=celsius+273.15;
        Far=(celsius*1.80)+32.00;
        return new double[]{kelvin,Far};
    }
}