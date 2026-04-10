package niccolosorrenti.u5d5_progetto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utente {

    @Id
    @GeneratedValue
    private UUID utente_id;

    private String username;

    private String nomeCompleto;

    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;
}
