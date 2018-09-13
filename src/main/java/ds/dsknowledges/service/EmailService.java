package ds.dsknowledges.service;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    /**
     * Method send message.
     *
     * @param message contains text, subject, recipient or recipients and link to resource on classpath.
     */
    void sendMessage(MimeMessage message);
}
