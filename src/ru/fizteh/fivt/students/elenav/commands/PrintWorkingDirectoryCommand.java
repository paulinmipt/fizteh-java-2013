package ru.fizteh.fivt.students.elenav.commands;

import java.io.IOException;
import java.io.PrintStream;

import ru.fizteh.fivt.students.elenav.shell.FilesystemState;

public class PrintWorkingDirectoryCommand extends AbstractCommand {
	public PrintWorkingDirectoryCommand(FilesystemState s) { 
		super(s, "pwd", 0);
	}
	
	public void execute(String args[], PrintStream s) throws IOException {
		try {
			s.println(getState().getWorkingDirectory().getCanonicalPath());
		} catch (SecurityException e) {
			throw new IOException(e.getMessage());
		}
	}
}
