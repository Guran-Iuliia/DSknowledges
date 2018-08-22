package ds.dsknowledges.service.impl.email;

import ds.dsknowledges.service.EmailBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@PropertySource("classpath:email.properties")
public abstract class EmailBuilderImpl<T> implements EmailBuilder<T> {

    @Value("${mail.from}")
    private String sender;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public MimeMessage buildMessage(T entity) {
        final MimeMessage message = javaMailSender.createMimeMessage();
        try {
            final MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
            message.setContent(getMessageBody(entity), "text/html; charset=UTF-8");
            helper.setSubject(this.getMessageSubject());
            helper.setFrom(this.sender);
            helper.setTo(this.getMessageRecipients());
            return message;
        } catch (MessagingException e) {
            return null;
        }    }

    abstract String getMessageSubject();

    abstract String getMessageBody(T entity);

    abstract String getMessageRecipients();

}
