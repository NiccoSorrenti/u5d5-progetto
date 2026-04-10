package niccolosorrenti.u5d5_progetto.entities;

import jakarta.persistence.*;
import lombok.*;
import niccolosorrenti.u5d5_progetto.enums.TipoPostazione;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Postazione {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID postazione_id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    private int maxOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;
}
