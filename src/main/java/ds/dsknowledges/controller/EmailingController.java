package ds.dsknowledges.controller;

import ds.dsknowledges.model.Emailing;
import ds.dsknowledges.service.EmailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emailing")
public class EmailingController {

    @Autowired
    private EmailingService emailingService;

    /**
     * Send message to admin for subscriber.
     *
     * @param emailing is object that contains user's email.
     * @return http status OK.
     */
    @PostMapping
    public ResponseEntity save(@RequestBody Emailing emailing) {
        emailingService.save(emailing);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
