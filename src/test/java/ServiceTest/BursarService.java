package ServiceTest;

import org.biic0.org.domain.Bursar;
import org.biic0.org.repository.BursarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BursarService {

    private final BursarRepository bursarRepository;

    @Autowired
    public BursarService(BursarRepository bursarRepository) {
        this.bursarRepository = bursarRepository;
    }

    public Bursar create(Bursar bursar) {
        return bursarRepository.save(bursar);
    }

    public List<Bursar> getAll() {
        return bursarRepository.findAll();
    }

    public Bursar read(String bursarID) {
        Optional<Bursar> bursar = bursarRepository.findById(bursarID);
        return bursar.orElse(null);
    }

    public Bursar update(Bursar bursar) {
        return bursarRepository.save(bursar);
    }

    public void delete(String bursarID) {
        bursarRepository.deleteById(bursarID);
    }
}
