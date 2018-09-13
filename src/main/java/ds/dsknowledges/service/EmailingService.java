package ds.dsknowledges.service;

import ds.dsknowledges.model.Emailing;

public interface EmailingService {

    /**
     * Creates emailing entity.
     *
     * @param emailing is entity.
     */
    void save(Emailing emailing);
}
