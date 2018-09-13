package ds.dsknowledges.service.impl;

import ds.dsknowledges.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Autowired
    private final JavaMailSender javaMailSender;

    /**
     * {@inheritDoc}.
     */
    @Override
    public void sendMessage(MimeMessage mimeMessage) {
        if (mimeMessage == null) {
            throw new RuntimeException("Message is null");
        }
        try {
            log.info("Sending message with subject: {} to: {}", mimeMessage.getSubject(), mimeMessage.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        this.javaMailSender.send(mimeMessage);
    }
}
