package niccolosorrenti.u5d5_progetto.repositories;

import niccolosorrenti.u5d5_progetto.entities.Postazione;
import niccolosorrenti.u5d5_progetto.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {

    List<Postazione> findByTipoPostazioneAndEdificio_Citta(TipoPostazione tipoPostazione, String citta);
}
