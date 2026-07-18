public class Forecast {

    // recursively grows the value by the growth rate, one year at a time
    public static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }
}
