import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Asvathama";
        int loginAttempts = 3;

        logger.info("User {} logged in", username);
        logger.warn("User {} failed login {} times", username, loginAttempts);
    }
}
