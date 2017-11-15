
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Properties;

interface IClock {
    LocalDateTime now();
}

interface IMailer {
    void sendMail(String to, String subject, String message);
}


class Clock implements IClock {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}

class Mailer implements IMailer {
    private String to;
    private String subject;
    private String message;
    Mailer(String to, String subject, String message){
        this.to = to;
        this.subject = subject;
        this.message = message;
    }
    @Override
    public void sendMail(String to, String subject, String message) {
        String host = "smtp.gmail.com";
        final String user = "hwshmel1131@gmail.com";
        final String password = "thisIsTestHw";

        String toEmail = this.getTo();


        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });


        try {
            MimeMessage mMessage = new MimeMessage(session);
            mMessage.setFrom(new InternetAddress(user));
            mMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mMessage.setSubject(this.getSubject());
            mMessage.setText(this.getMessage());


            Transport.send(mMessage);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private String getTo() {
        return to;
    }

    private String getSubject() {
        return subject;
    }

    private String getMessage() {
        return message;
    }
}

public class ClockMailer{
    private IClock clock;
    private IMailer mailer;
    private String to;
    private String subject;
    private String message;

    ClockMailer(IClock clock, IMailer mailer, String to, String subject, String message) {
        this.clock = clock;
        this.mailer = mailer;
        ifMailProperTimeSend(to, subject, message);
    }

    private void ifMailProperTimeSend(String to, String subject, String message) {

    }


}

class SendMailBySite {
    public static void main(String[] args) {
        System.out.println();

    }
}