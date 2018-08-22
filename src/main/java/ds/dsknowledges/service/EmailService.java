package ds.dsknowledges.service;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    void sendMessage(MimeMessage mimeMessage);
}
