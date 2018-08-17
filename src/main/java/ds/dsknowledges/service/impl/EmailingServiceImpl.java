package ds.dsknowledges.service.impl;

import ds.dsknowledges.model.Emailing;
import ds.dsknowledges.repository.EmailingRepository;
import ds.dsknowledges.service.EmailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class EmailingServiceImpl implements EmailingService {

    @Autowired
    private EmailingRepository emailingRepository;

    @Override
    public Emailing save(Emailing emailing) {
        Assert.notNull(emailing, "emailing is null");
        return emailingRepository.save(emailing);
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "id is null");
        emailingRepository.delete(id);
    }
}
