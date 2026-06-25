public class RemoteControl {

	Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressButton() {
		// runs whatever command is currently set
		command.execute();
	}
}
