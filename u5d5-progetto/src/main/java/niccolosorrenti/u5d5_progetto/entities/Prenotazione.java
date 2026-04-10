package niccolosorrenti.u5d5_progetto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"utente_id", "data"}), @UniqueConstraint(columnNames = {"postazione_id", "data"})})
public class Prenotazione {

    @Id
    @GeneratedValue
    private UUID prenotazione_id;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;
}
