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
public class Edificio {

    @Id
    @GeneratedValue
    private UUID edificio_id;

    private String nome;

    private String indirizzo;

    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;
}
