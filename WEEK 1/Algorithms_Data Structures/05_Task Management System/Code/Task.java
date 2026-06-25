public class Task {

	int taskId;
	String taskName;
	String status;

	Task(int taskId, String taskName, String status) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.status = status;
	}

	public String toString() {
		return taskId + " - " + taskName + " | status: " + status;
	}
}
