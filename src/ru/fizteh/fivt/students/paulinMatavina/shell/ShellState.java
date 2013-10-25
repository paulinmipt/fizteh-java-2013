package ru.fizteh.fivt.students.paulinMatavina.shell;

import java.io.File;
import java.util.HashMap;
import ru.fizteh.fivt.students.paulinMatavina.utils.*;

public class ShellState extends State{    
    public ShellState() {
        commands = new HashMap<String, Command>();
        currentDir = new File(".");
        this.add(new ShellDir());
        this.add(new ShellCd());
        this.add(new ShellRm());
        this.add(new ShellMove());
        this.add(new ShellPwd());
        this.add(new ShellCopy());
        this.add(new ShellExit());
        this.add(new ShellMkdir());
    }
    
    public int cd(final String source) {
        File newDir = new File(makeNewSource(source));
        if (!newDir.exists()) {
            System.err.println("cd: " + source + ": is not a directory");
            return 2;
        }
        
        if  (!newDir.isDirectory()) {
            System.err.println("cd: " + source + ": is not a directory");
            return 1;
        }
        try {
            if (newDir.isAbsolute()) {
                currentDir = newDir;
            } else {
                currentDir = new File(currentDir.getCanonicalPath()
                            + File.separator + newDir);
            }
        } catch (Exception e) {
            System.err.println("cd: " + source
                    + ": is not a correct directory");
            return 1;
        }
        return 0;
    }
    
    public int rm(String[] args) {
        Command rm = new ShellRm();
        return rm.execute(args, this);
    }
    
    public int pwd(String[] args) {
        Command pwd = new ShellPwd();
        return pwd.execute(args, this);
    }
    
    public int cd(String[] args) {
        Command cd = new ShellCd();
        return cd.execute(args, this);
    }
    
    public int mkdir(String[] args) {
        Command mkdir = new ShellMkdir();
        return mkdir.execute(args, this);
    }
    
    public int move(String[] args) {
        Command move = new ShellMove();
        return move.execute(args, this);
    }
    
    public int copy(String[] args) {
        Command copy = new ShellCopy();
        return copy.execute(args, this);
    }
    
    public int dir(String[] args) {
        Command dir = new ShellDir();
        return dir.execute(args, this);
    }
    
    public int exit(String[] args) {
        Command exit = new ShellRm();
        return exit.execute(args, this);
    }
}
