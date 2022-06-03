package it.uniba.app.entity;

import it.uniba.app.control.Controllo;

public class Giocatore extends Utente {
    /**
     * nTentativi : numero di tentativi massimp affidati al giocatore
     */
    private int nTentativi;
    /**
     * parola_Giocatore : parola inserita dall'utente
     */
    private String parola_Giocatore;
    /**
     * controllo : oggetto controllo
     */
    private Controllo controllo;

    /**
     *
     * @param id :id dell'utente
     */
    public Giocatore(final int id) {
        super(id);
        nTentativi = -1;
    }

    /**
     *
     * @param username : usermname dell'utente
     * @param id : id dell'utente
     * @param nTentativi : numero di tentativi massimo del giocatore
     * @param parola_Giocatore : parola inserita dal giocatore
     */
    public Giocatore(final String username, final int id, final int nTentativi,  final String parola_Giocatore) {
        super(username, id);
        this.nTentativi = nTentativi;
        this.parola_Giocatore = parola_Giocatore;
    }

    /**
     *
     * @param id : id dell'utente
     * @param nTentativi : numero dei tentativi massimo concesso al''utente
     * @param parola_Giocatore : parola inserita dal giocatore
     */
    public Giocatore(final int id, final int nTentativi, final String parola_Giocatore) {
        super(id);
        this.nTentativi = nTentativi;
        this.parola_Giocatore = parola_Giocatore;
    }

    /**
     *
     * @return : ritorna il numero di tentativi
     */
    public final int getnTentativi() {
        return nTentativi;
    }

    /**
     *
     * @param nTentativi : ritorna il numero di tentativi
     */
    public final void setnTentativi(final int nTentativi) {
        this.nTentativi = nTentativi;
    }

    /**
     *
     * @return : la parola del giocatore
     */
    public final String getParola_Giocatore() {
        return parola_Giocatore;
    }

    /**
     *
     * @param parola_Giocatore : la parola del giocatore
     */
    public final void setParola_Giocatore(final String parola_Giocatore) {
        this.parola_Giocatore = parola_Giocatore;
    }

    /**
     *
     * @return : oggetto di tipo controllo
     */
    public final Controllo getControllo() {
        return controllo;
    }

    /**
     *
     * @param controllo : oggetto controllo
     */
    public final void setControllo(final Controllo controllo) {
        this.controllo = controllo;
    }

    /**
     * incrementa il numero di tentativi
     */
    public final void incrTentativi() {
        nTentativi++;
    }
}
