package niccolosorrenti.u5d5_progetto.repositories;

import niccolosorrenti.u5d5_progetto.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EdificioRepository extends JpaRepository<Edificio, UUID> {
}
