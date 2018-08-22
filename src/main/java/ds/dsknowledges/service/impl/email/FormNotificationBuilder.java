package ds.dsknowledges.service.impl.email;

import ds.dsknowledges.dto.ContactDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:email.properties")
public class FormNotificationBuilder extends EmailBuilderImpl<ContactDTO> {

    @Value("${mail.email}")
    private String recipient;

    private static final String SUBJECT = "New contact";

    @Override
    String getMessageSubject() {
        return SUBJECT;
    }

    @Override
    String getMessageBody(ContactDTO contactDTO) {
        return "Dear admin you have new contact "
                + contactDTO.getName()
                + " email:"
                + contactDTO.getEmail();
    }

    @Override
    String getMessageRecipients() {
        return recipient;
    }
}
