package niccolosorrenti.u5d5_progetto.services;

import niccolosorrenti.u5d5_progetto.entities.Utente;
import niccolosorrenti.u5d5_progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Utente> ottieniTuttiGliUtenti() {
        return utenteRepository.findAll();
    }

    public Utente ottieniUtentePerId(UUID id) {
        return utenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Utente non trovato"));
    }

    public Utente salvaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public void cancellaUtentePerId(UUID id) {
        Utente found = this.ottieniUtentePerId(id);

        utenteRepository.delete(found);

        System.out.println("L'utente " + found.getUtente_id() + " è stato eliminato correttamente");
    }
}
