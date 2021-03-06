package ru.fizteh.fivt.students.mishatkin.shell;

/**
 * CopyCommand.java
 * Created by Vladimir Mishatkin on 9/25/13
 */
public class CopyCommand extends Command {
	CopyCommand(CommandReceiver receiver) {
		super(receiver);
		setInputArgumentsCount(2);
		type = CommandType.CP;
	}

	@Override
	public void execute() throws ShellException {
		receiver.copyCommand(args[0], args[1]);
	}
}
