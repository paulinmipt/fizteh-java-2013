package ru.fizteh.fivt.students.anastasyev.filemap;

import ru.fizteh.fivt.students.anastasyev.shell.Command;

public class GetCommand implements Command {
    private FileMapLauncher fileMapLauncher;

    public GetCommand(FileMapLauncher myFileMapLauncher) {
        fileMapLauncher = myFileMapLauncher;
    }

    @Override
    public boolean exec(String[] command) {
        if (command.length != 2) {
            System.err.println("get: Usage - get key");
            return false;
        }
        try {
            String str = fileMapLauncher.getFileMap().get(command[1]);
            if (str.equals("not found")) {
                System.out.println("not found");
            } else {
                System.out.println("found");
                System.out.println(str);
            }
        } catch (Exception e) {
            System.err.println("get: Can't get the key");
            return false;
        }
        return true;
    }

    @Override
    public String commandName() {
        return "get";
    }
}
