package app.command;

import app.entities.Problem;
import lombok.Value;

@Value
public class AskForHelp {

    public String name;
    public Problem problem;

}
