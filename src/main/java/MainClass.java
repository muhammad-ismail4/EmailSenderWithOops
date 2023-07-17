import javax.mail.MessagingException;

public class MainClass {

    public static void main(String[] args) {
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "";
        String password = "";

        EmailSender emailSender = new EmailSender(host, port, username, password);

        try {

            String recipient = "";
            String subject = "Hi ";
            String body = "Testing";

            emailSender.SendEmail(recipient,subject,body);
        }
         catch (MessagingException me){

             System.out.println(" Failed to send email : " + me.getMessage());
         }
    }
}
