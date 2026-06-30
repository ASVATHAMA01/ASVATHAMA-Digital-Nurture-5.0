import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

public class PerformanceTesterTest {

	PerformanceTester tester = new PerformanceTester();

	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void testPerformTaskWithinTimeout() throws InterruptedException {
		tester.performTask();
	}
}
