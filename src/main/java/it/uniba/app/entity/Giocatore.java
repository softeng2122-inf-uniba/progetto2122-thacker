package it.uniba.app.entity;

import it.uniba.app.control.Controllo;

public class Giocatore extends Utente {
    /**
     * nTentativi : numero di tentativi massimp affidati al giocatore.
     */
    private int nTentativi;
    /**
     * parola_Giocatore : parola inserita dall'utente.
     */
    private String parolaGiocatore;
    /**
     * controllo : oggetto controllo.
     */
    private Controllo controllo;

    /**
     * costruttore.
     * @param id :id dell'utente
     */
    public Giocatore(final int id) {
        super(id);
        nTentativi = -1;
    }

    /**
     * costruttore.
     * @param username : usermname dell'utente
     * @param id : id dell'utente
     * @param nTent : numero di tentativi massimo del giocatore
     * @param parGiocatore : parola inserita dal giocatore
     */
    public Giocatore(final String username,
                     final int id,
                     final int nTent,
                     final String parGiocatore) {
        super(username, id);
        this.nTentativi =
                nTent;
        this.parolaGiocatore =
                parGiocatore;
    }

    /**
     * costruttore.
     * @param id : id dell'utente
     * @param nTent : numero
     *                   dei tentativi massimo
     *                   concesso al''utente
     * @param parGiocatore : parola
     *                         inserita dal giocatore
     */
    public Giocatore(final int id,
                     final int nTent,
                     final String parGiocatore) {
        super(id);
        this.nTentativi =
                nTent;
        this.parolaGiocatore =
                parGiocatore;
    }

    /**
     * restituisce il
     * numero di tentativi.
     * @return : ritorna il
     * numero di tentativi
     */
    public final int getnTentativi() {
        return nTentativi;
    }

    /**
     * imposta il numero
     * di tentativi.
     * @param nTent : numero di tentativi
     */
    public final void setnTentativi(final int nTent) {
        this.nTentativi = nTent;
    }

    /**
     * restituisce la
     * parola del giocatore.
     * @return : la parola del giocatore
     */
    public final String getParolaGiocatore() {
        return parolaGiocatore;
    }

    /**
     * imposta la parola del
     * giocatore.
     * @param parGiocatore :
     *                        la parola del giocatore
     */
    public final void setParolaGiocatore(
            final String parGiocatore) {
        this.parolaGiocatore = parGiocatore;
    }

    /**
     * restituisce l'oggetto
     * controllo.
     * @return : oggetto di tipo controllo
     */
    public final Controllo getControllo() {
        return controllo;
    }

    /**
     * imposta l'oggetto
     * controllo.
     * @param control : oggetto controllo
     */
    public final void setControllo(
            final Controllo control) {
        this.controllo = control;
    }

    /**
     * incrementa il numero di tentativi.
     */
    public final void incrTentativi() {
        nTentativi++;
    }
}
