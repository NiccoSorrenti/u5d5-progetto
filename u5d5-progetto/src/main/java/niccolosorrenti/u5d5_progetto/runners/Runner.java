package niccolosorrenti.u5d5_progetto.runners;

import niccolosorrenti.u5d5_progetto.entities.Edificio;
import niccolosorrenti.u5d5_progetto.entities.Postazione;
import niccolosorrenti.u5d5_progetto.entities.Utente;
import niccolosorrenti.u5d5_progetto.enums.TipoPostazione;
import niccolosorrenti.u5d5_progetto.services.EdificioService;
import niccolosorrenti.u5d5_progetto.services.PostazioneService;
import niccolosorrenti.u5d5_progetto.services.PrenotazioneService;
import niccolosorrenti.u5d5_progetto.services.UtenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class Runner implements CommandLineRunner {

    private final EdificioService edificioService;
    private final PostazioneService postazioneService;
    private final PrenotazioneService prenotazioneService;
    private final UtenteService utenteService;


    public Runner(EdificioService edificioService, PostazioneService postazioneService, PrenotazioneService prenotazioneService, UtenteService utenteService) {
        this.edificioService = edificioService;
        this.postazioneService = postazioneService;
        this.prenotazioneService = prenotazioneService;
        this.utenteService = utenteService;
    }

    @Override
    public void run(String... args) throws Exception {
        Utente u1 = new Utente();
        u1.setUsername("mario");
        u1.setNomeCompleto("Mario Rossi");
        u1.setEmail("mario@email.it");

        Utente u2 = new Utente();
        u2.setUsername("luca");
        u2.setNomeCompleto("Luca Bianchi");
        u2.setEmail("luca@email.it");

//        utenteService.salvaUtente(u1);
//        utenteService.salvaUtente(u2);


        Edificio e1 = new Edificio();
        e1.setNome("Sede Milano");
        e1.setIndirizzo("Via Roma 1");
        e1.setCitta("Milano");

//        edificioService.salavaEdificio(e1);
        Edificio edificioFromDB = edificioService.ottieniEdificioPerId(UUID.fromString("0449d5a4-cff3-4224-9496-fadb024cd16c"));


        Postazione p1 = new Postazione();
        p1.setDescrizione("Scrivania privata");
        p1.setTipoPostazione(TipoPostazione.PRIVATO);
        p1.setMaxOccupanti(1);
        p1.setEdificio(edificioFromDB);

        Postazione p2 = new Postazione();
        p2.setDescrizione("Open space");
        p2.setTipoPostazione(TipoPostazione.OPENSPACE);
        p2.setMaxOccupanti(5);
        p2.setEdificio(edificioFromDB);

//        postazioneService.salvaPostazione(p1);
//        postazioneService.salvaPostazione(p2);


        LocalDate data = LocalDate.now().plusDays(1);

        System.out.println("CREO PRENOTAZIONE 1");

        UUID utenteFromDB = utenteService.ottieniUtentePerId(UUID.fromString("d924b41a-f7e2-4663-ba2c-1e2863e8986d")).getUtente_id();
        UUID postazioneFromDB = postazioneService.ottieniPostazionePerId(UUID.fromString("7ac10867-0308-4b6e-a6ac-f8a080de34ca")).getPostazione_id();

        prenotazioneService.creaPrenotazione(utenteFromDB, postazioneFromDB, data);

//        prenotazioneService.creaPrenotazione(u1.getUtente_id(), p1.getPostazione_id(), data);

    }
}
