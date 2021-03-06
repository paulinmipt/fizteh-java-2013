package ru.fizteh.fivt.students.valentinbarishev.filemap;

import ru.fizteh.fivt.students.valentinbarishev.shell.SimpleShellCommand;

public class ShellDbGet extends SimpleShellCommand {
    private DataBase dataBase;

    public ShellDbGet(final DataBase newBase) {
        setName("get");
        setNumberOfArgs(2);
        setHint("usage: get <key>");
        dataBase = newBase;
    }

    @Override
    public void run() {
        String str = dataBase.get(getArg(1));
        if (str.isEmpty()) {
            System.out.println("not found");
        } else {
            System.out.println("found");
            System.out.println(str);
        }
    }
}
