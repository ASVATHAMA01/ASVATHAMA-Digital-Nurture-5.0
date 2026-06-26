public class ForecastTest {

	public static void main(String[] args) {

		double presentValue = 100000.0;
		double growthRate = 0.08;
		int years = 5;

		double result = Forecast.futureValue(presentValue, growthRate, years);

		System.out.println("Present value: " + presentValue);
		System.out.println("Growth rate: " + growthRate);
		System.out.println("Years: " + years);
		System.out.println("Future value: " + result);
	}
}
