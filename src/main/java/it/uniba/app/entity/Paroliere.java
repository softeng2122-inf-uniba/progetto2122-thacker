package it.uniba.app.entity;

import it.uniba.app.control.Controllo;

public class Paroliere extends Utente {
    /**
     * parola_Paroliere : parola da indovinare.
     */
    private String parola_Paroliere;
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
     * @param par_Paroliere : parola segreta da indovinare
     */
    public Paroliere(final int id, final String par_Paroliere) {
        super(id);
        this.parola_Paroliere = par_Paroliere;
    }

    /**
     * costruttore.
     * @param id : id  del paroliere
     * @param par_Paroliere : parola segreta da indovinare
     * @param username : username del paroliere
     */
    public Paroliere(final int id,
                     final String par_Paroliere,
                     final String username) {
        super(username, id);
        this.parola_Paroliere = par_Paroliere;
    }

    /**
     * restituisce la parola.
     * del paroliere.
     * @return : parola del paroliere
     */
    public final String getParola_Paroliere() {
        return parola_Paroliere;
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
     * @param par_Paroliere : parola segreta inserita dal paroliere
     */
    public final void impostaParola(final String par_Paroliere) {
        this.parola_Paroliere = par_Paroliere;
    }
}
