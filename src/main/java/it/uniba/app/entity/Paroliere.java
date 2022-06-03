package it.uniba.app.entity;

import it.uniba.app.control.Controllo;

public class Paroliere extends Utente {
    /**
     * parola_Paroliere : parola da indovinare
     */
    private String parola_Paroliere;
    /**
     * oggetto controllo
     */
    private Controllo controllo;

    /**
     *
     * @param id : id del paroliere
     */
    public Paroliere(final int id) {
        super(id);
    }

    /**
     *
     * @param id : id del paroliere
     * @param parola_Paroliere : parola segreta da indovinare
     */
    public Paroliere(final int id, final String parola_Paroliere) {
        super(id);
        this.parola_Paroliere = parola_Paroliere;
    }

    /**
     *
     * @param id : id  del paroliere
     * @param parola_Paroliere : parola segreta da indovinare
     * @param username : username del paroliere
     */
    public Paroliere(final int id, final String parola_Paroliere, final String username) {
        super(username, id);
        this.parola_Paroliere = parola_Paroliere;
    }

    /**
     *
     * @return : parola del paroliere
     */
    public final String getParola_Paroliere() {
        return parola_Paroliere;
    }

    /**
     *
     * @return : oggetto controllo
     */
    public final Controllo getControllo() {
        return controllo;
    }

    /**
     *
     * @param controllo :  oggetto controllo
     */
    public final void setControllo(final Controllo controllo) {
        this.controllo = controllo;
    }

    /**
     *
     * @param parola_Paroliere : parola segreta inserita dal paroliere
     */
    public final void impostaParola(final String parola_Paroliere) {
        this.parola_Paroliere = parola_Paroliere;
    }
}
