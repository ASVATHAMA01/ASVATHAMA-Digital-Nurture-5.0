import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLoggingExample {

	private static final Logger logger = LoggerFactory.getLogger(AppenderLoggingExample.class);

	public static void main(String[] args) {
		logger.debug("debug message, only goes to file and console since root level is debug");
		logger.info("application started");
		logger.error("something went wrong while processing");
	}
}
