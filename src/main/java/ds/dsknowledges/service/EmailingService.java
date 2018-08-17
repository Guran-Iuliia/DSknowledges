package ds.dsknowledges.service;

import ds.dsknowledges.model.Emailing;

public interface EmailingService {

    Emailing save(Emailing emailing);

    void delete(Long id);
}
