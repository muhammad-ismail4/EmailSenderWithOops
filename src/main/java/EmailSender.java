
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {
   private String host;
   private int port;
   private String username;
   private String password;

   public EmailSender(String host, int port, String username, String password){

       this.host = host;
       this.port = port;
       this.username = username;
       this.password = password;

   }

   public void SendEmail(String recipient, String subject, String body) throws MessagingException {

       Properties properties = new Properties();
       properties.put("mail.smtp.auth","true");
       properties.put("mail.smtp.starttls.enable","true");
       properties.put("mail.smtp.host",host);
       properties.put("mail.smtp.port",port);

       Session session = Session.getInstance(properties, new Authenticator() {
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
           }
       });

       Message message = new MimeMessage(session);
       message.setFrom(new InternetAddress(username));
       message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
       message.setSubject(subject);
       message.setText(body);

       Transport.send(message);

       System.out.println("Email sent successfully! ");
   }
}
