import javax.mail.MessagingException;

public class MainClass {

    public static void main(String[] args) {
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "mismailkhan.pakistan@gmail.com";
        String password = "Itsallabout4@";

        EmailSender emailSender = new EmailSender(host, port, username, password);

        try {

            String recipient = "muhammadismailkhan28@gmail.com";
            String subject = "Hi ";
            String body = "Testing";

            emailSender.SendEmail(recipient,subject,body);
        }
         catch (MessagingException me){

             System.out.println(" Failed to send email : " + me.getMessage());
         }
    }
}
