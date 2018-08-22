package ds.dsknowledges.service;

import javax.mail.internet.MimeMessage;

public interface EmailBuilder<T> {

    MimeMessage buildMessage(T entity);
}
