package niccolosorrenti.u5d5_progetto.services;

import niccolosorrenti.u5d5_progetto.entities.Edificio;
import niccolosorrenti.u5d5_progetto.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public List<Edificio> ottieniTuttiGliEdifici() {
        return edificioRepository.findAll();
    }

    public Edificio ottieniEdificioPerId(UUID id) {
        return edificioRepository.findById(id).orElseThrow(() -> new RuntimeException("Edificio non trovato"));
    }

    public Edificio salavaEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public void delete(UUID id) {
        Edificio found = this.ottieniEdificioPerId(id);

        edificioRepository.delete(found);

        System.out.println("L'utente " + found.getEdificio_id() + " è stato eliminato correttamente");
    }
}
