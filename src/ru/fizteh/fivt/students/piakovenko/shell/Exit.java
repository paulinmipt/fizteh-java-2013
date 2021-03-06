package ru.fizteh.fivt.students.piakovenko.shell;

/**
 * Created with IntelliJ IDEA.
 * User: Pavel
 * Date: 11.10.13
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */
public class Exit implements Commands {
    private final String name = "exit";
    private CurrentStatus currentStatus;

    public Exit(CurrentStatus cs) {
        currentStatus = cs;
    }

    public String getName() {
        return name;
    }


    public void perform(String[] s) throws MyException {
        if (s.length != 1) {
            throw new MyException(new Exception("Wrong arguments! Usage ~ exit"));
        }
       System.exit(0);
    }
}
