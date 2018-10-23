package pl.zarosla.webapp.BusinessModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailComposer {

    @Autowired
    private static JavaMailSender sender;

    public static void registrationEmail(String email, String token) throws MessagingException {
        String encodingOptions = "text/html; charset=UTF-8";
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        message.setHeader("Content type",encodingOptions);
        helper.setTo(email);
        helper.setSubject("Zarosla app - verificatione email");
        helper.setText(activationMassage(email,token));
        sender.send(message);
    }
    private static String activationMassage(String email, String token){
        return "<H1> Hi!</H1>" +
                "<br>" +
                "You have just created your account!" +
                "<br>"+
                "To activate it, please go to this adress"+
                "<br>"+
                "<a href=\"localhost:8080/user/activation/"+token+">Activation adress</a>";

    }

}
