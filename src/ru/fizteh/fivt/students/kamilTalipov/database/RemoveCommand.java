package ru.fizteh.fivt.students.kamilTalipov.database;

import ru.fizteh.fivt.students.kamilTalipov.shell.Shell;
import ru.fizteh.fivt.students.kamilTalipov.shell.SimpleCommand;

public class RemoveCommand extends SimpleCommand {
    public RemoveCommand(Database database) {
        super("remove", 1);
        this.database = database;
    }

    @Override
    public void run(Shell shell, String[] args) throws IllegalArgumentException {
        if (numberOfArguments != args.length) {
            throw new IllegalArgumentException(name + ": expected " + numberOfArguments
                                                + " but " + args.length + " got");
        }

        String value = database.remove(args[0]);
        if (value == null) {
            System.out.println("not found");
        }  else {
            System.out.println("removed");
        }
    }

    private final Database database;
}
