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

    @PostMapping
    public ResponseEntity<Emailing> save(@RequestBody Emailing emailing) {
        Emailing savedEmailing = emailingService.save(emailing);
        return new ResponseEntity<>(savedEmailing, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Emailing> delete(@PathVariable("id") Long id) {
        emailingService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
