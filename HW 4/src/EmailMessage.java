
import java.time.LocalDateTime;

public class EmailMessage {
    String subject;
    String message;
    String from;
    String to;
    LocalDateTime dateTime;


    public EmailMessage(String subject, String message, String from, String to, LocalDateTime dateTime) {
        this.subject = subject;
        this.message = message;
        this.from = from;
        this.to = to;
        this.dateTime = dateTime;
    }





}
