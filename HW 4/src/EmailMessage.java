
import java.time.LocalDateTime;
import java.util.Date;

public class EmailMessage {
    private String subject;
    private String message;
    private String from;
    private String to;
    private Date dateTime;


    public EmailMessage(String subject, String message, String from, String to, Date dateTime) {
        this.setSubject(subject);
        this.setMessage(message);
        this.setFrom(from);
        this.setTo(to);
        this.setDateTime(dateTime);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
