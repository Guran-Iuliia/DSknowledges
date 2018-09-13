package ds.dsknowledges.service;

import javax.mail.internet.MimeMessage;

/**
 * The <code>EmailBuilder</code> interface describes contract for
 * constructing {@link MimeMessage} email message for provided entity.
 */
public interface EmailBuilder<T> {

    /**
     * Constructs {@link MimeMessage} for provided entity.
     *
     * @param entity an entity to construct email for.
     * @return complete {@link MimeMessage} email message.
     */
    MimeMessage buildMessage(T entity);
}
