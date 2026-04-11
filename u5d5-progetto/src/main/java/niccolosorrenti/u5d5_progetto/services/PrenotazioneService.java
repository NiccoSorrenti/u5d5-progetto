package niccolosorrenti.u5d5_progetto.services;

import niccolosorrenti.u5d5_progetto.entities.Postazione;
import niccolosorrenti.u5d5_progetto.entities.Prenotazione;
import niccolosorrenti.u5d5_progetto.entities.Utente;
import niccolosorrenti.u5d5_progetto.repositories.PostazioneRepository;
import niccolosorrenti.u5d5_progetto.repositories.PrenotazioneRepository;
import niccolosorrenti.u5d5_progetto.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public Prenotazione creaPrenotazione(UUID utenteId, UUID postazioneId, LocalDate data) {

        Utente utente = utenteRepository.findById(utenteId).orElseThrow(() -> new RuntimeException("Utente non trovato"));

        Postazione postazione = postazioneRepository.findById(postazioneId).orElseThrow(() -> new RuntimeException("Postazione non trovata"));

        // postazione occupata
        if (prenotazioneRepository.existsByPostazioneAndData(postazione, data)) {
            throw new RuntimeException("Postazione già occupata");
        }

        // utente già prenotato quel giorno
        if (prenotazioneRepository.existsByUtenteAndData(utente, data)) {
            throw new RuntimeException("L'Utente ha già una prenotazione in questa data");
        }

        Prenotazione p = new Prenotazione();
        p.setData(data);
        p.setUtente(utente);
        p.setPostazione(postazione);

        return prenotazioneRepository.save(p);
    }

    public List<Prenotazione> ottieniTutteLePrenotazioni() {
        return prenotazioneRepository.findAll();
    }
}
