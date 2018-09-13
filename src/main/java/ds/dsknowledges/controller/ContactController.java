package ds.dsknowledges.controller;

import ds.dsknowledges.dto.ContactDTO;
import ds.dsknowledges.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Igor Hnes on 9/1/18.
 */
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    /**
     * Send message to admin for new contact.
     *
     * @param contactDTO is object that contains information of user.
     * @return http status OK.
     */
    @PostMapping
    public ResponseEntity save(@RequestBody ContactDTO contactDTO) {
        contactService.save(contactDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
