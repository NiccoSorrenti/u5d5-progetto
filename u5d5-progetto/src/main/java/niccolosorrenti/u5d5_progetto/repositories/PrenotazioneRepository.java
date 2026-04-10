package niccolosorrenti.u5d5_progetto.repositories;

import niccolosorrenti.u5d5_progetto.entities.Postazione;
import niccolosorrenti.u5d5_progetto.entities.Prenotazione;
import niccolosorrenti.u5d5_progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
    
    boolean existsByPostazioneAndData(Postazione postazione, LocalDate data);

    boolean existsByUtenteAndData(Utente utente, LocalDate data);
}
