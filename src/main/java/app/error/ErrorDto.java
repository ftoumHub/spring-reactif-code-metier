package app.error;
import io.vavr.control.Option;
import lombok.Value;

@Value
public class ErrorDto {

    public String message;
    public Option<String> path;
}
