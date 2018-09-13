package ds.dsknowledges.service;

import ds.dsknowledges.dto.ContactDTO;

public interface ContactService {

    /**
     * Creates new emailing entity and send message to admin.
     *
     * @param contactDTO is object with user information.
     */
    void save(ContactDTO contactDTO);
}
