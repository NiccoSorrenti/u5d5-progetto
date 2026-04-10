package niccolosorrenti.u5d5_progetto.services;

import niccolosorrenti.u5d5_progetto.entities.Postazione;
import niccolosorrenti.u5d5_progetto.enums.TipoPostazione;
import niccolosorrenti.u5d5_progetto.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public List<Postazione> cercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

    public Postazione salvaPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public List<Postazione> ottieniTutteLePostazioni() {
        return postazioneRepository.findAll();
    }

    public Postazione ottieniPostazionePerId(UUID id) {
        return postazioneRepository.findById(id).orElseThrow(() -> new RuntimeException("Postazione non trovata"));
    }
}
