package adv2.chat.server.command;

import adv2.chat.server.Session;
import adv2.chat.server.command.Command;

import java.io.IOException;

public class ExitCommand implements Command {

    @Override
    public void execute(String[] args, Session session) throws IOException {
        throw new IOException("exit");
    }
}
