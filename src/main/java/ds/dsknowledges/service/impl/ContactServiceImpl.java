package ds.dsknowledges.service.impl;

import ds.dsknowledges.dto.ContactDTO;
import ds.dsknowledges.service.ContactService;
import ds.dsknowledges.service.EmailBuilder;
import ds.dsknowledges.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.mail.internet.MimeMessage;

@Transactional
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private EmailService emailService;
    @Autowired
    @Qualifier("formNotificationBuilder")
    private EmailBuilder<ContactDTO> emailBuilder;

    /**
     * {@inheritDoc}.
     */
    @Override
    public void save(ContactDTO contactDTO) {
        Assert.notNull(contactDTO, "emailing is null");
        final MimeMessage message = emailBuilder.buildMessage(contactDTO);
        emailService.sendMessage(message);
    }
}
