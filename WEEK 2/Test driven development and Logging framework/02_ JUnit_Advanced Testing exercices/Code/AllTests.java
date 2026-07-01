import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SelectClasses({EvenCheckerTest.class, ExceptionThrowerTest.class})
public class AllTests {
	// no body needed, annotations do the work
}
