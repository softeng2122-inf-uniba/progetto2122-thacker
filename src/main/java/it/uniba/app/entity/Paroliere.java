package it.uniba.app.entity;

import it.uniba.app.control.Controllo;

public class Paroliere extends Utente {
    /**
     * parola_Paroliere : parola da indovinare.
     */
    private String parolaParoliere;
    /**
     * oggetto controllo.
     */
    private Controllo controllo;

    /**
     * costruttore.
     * @param id : id del paroliere
     */
    public Paroliere(final int id) {
        super(id);
    }

    /**
     * costruttore.
     * @param id : id del paroliere
     * @param parParoliere : parola segreta da indovinare
     */
    public Paroliere(final int id, final String parParoliere) {
        super(id);
        this.parolaParoliere = parParoliere;
    }

    /**
     * costruttore.
     * @param id : id  del paroliere
     * @param parParoliere : parola segreta da indovinare
     * @param username : username del paroliere
     */
    public Paroliere(final int id,
                     final String parParoliere,
                     final String username) {
        super(username, id);
        this.parolaParoliere = parParoliere;
    }

    /**
     * restituisce la parola.
     * del paroliere.
     * @return : parola del paroliere
     */
    public final String getParolaParoliere() {
        return parolaParoliere;
    }

    /**
     * restituisce l'oggetto.
     * controllo.
     * @return : oggetto controllo
     */
    public final Controllo getControllo() {
        return controllo;
    }

    /**
     * imposta l'oggetto
     * controllo.
     * @param control :  oggetto controllo
     */
    public final void setControllo(final Controllo control) {
        this.controllo = control;
    }

    /**
     * imposta la
     * parola del
     * paroliere.
     * @param parParoliere : parola segreta inserita dal paroliere
     */
    public final void impostaParola(final String parParoliere) {
        this.parolaParoliere = parParoliere;
    }
}
