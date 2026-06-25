public class MVCPatternTest {

	public static void main(String[] args) {

		Student student = new Student("Asvathama S K", "S101", "A");
		StudentView view = new StudentView();

		StudentController controller = new StudentController(student, view);

		controller.updateView();

		// update grade after re-evaluation and show again
		controller.setStudentGrade("A+");

		controller.updateView();
	}
}
