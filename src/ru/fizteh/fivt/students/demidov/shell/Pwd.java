package ru.fizteh.fivt.students.demidov.shell;

public class Pwd implements BasicCommand {
	public void executeCommand(String[] arguments, Shell usedShell) {    
		System.out.println(usedShell.curShell.getCurrentDirectory());
	}
	public int getNumberOfArguments() {
		return 0;
	}	
	public String getCommandName() {
		return "pwd";
	}
}
