package ru.fizteh.fivt.students.dubovpavel.filemap.Performers;

import ru.fizteh.fivt.students.dubovpavel.executor.Dispatcher;
import ru.fizteh.fivt.students.dubovpavel.filemap.DispatcherFileMap;
import ru.fizteh.fivt.students.dubovpavel.executor.Command;
import ru.fizteh.fivt.students.dubovpavel.executor.PerformerException;

public class PerformerGet extends PerformerFileMap {
    public boolean pertains(Command command) {
        return command.getHeader().equals("get") && command.argumentsCount() == 1;
    }
    public void execute(DispatcherFileMap dispatcher, Command command) throws PerformerException {
        String value = dispatcher.getDataBase().get(command.getArgument(0));
        if(value == null) {
            dispatcher.callbackWriter(Dispatcher.MessageType.ERROR, "not found");
        } else {
            dispatcher.callbackWriter(Dispatcher.MessageType.SUCCESS, String.format("found\n%s", value));
        }
    }
}
