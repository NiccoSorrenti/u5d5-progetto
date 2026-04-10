package niccolosorrenti.u5d5_progetto.repositories;

import niccolosorrenti.u5d5_progetto.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UtenteRepository extends JpaRepository<Utente, UUID> {
}
