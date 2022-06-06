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
    private String parola_Giocatore;
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
     * @param par_Giocatore : parola inserita dal giocatore
     */
    public Giocatore(final String username,
                     final int id,
                     final int nTent,
                     final String par_Giocatore) {
        super(username, id);
        this.nTentativi =
                nTent;
        this.parola_Giocatore =
                par_Giocatore;
    }

    /**
     * costruttore.
     * @param id : id dell'utente
     * @param nTent : numero
     *                   dei tentativi massimo
     *                   concesso al''utente
     * @param par_Giocatore : parola
     *                         inserita dal giocatore
     */
    public Giocatore(final int id,
                     final int nTent,
                     final String par_Giocatore) {
        super(id);
        this.nTentativi =
                nTent;
        this.parola_Giocatore =
                par_Giocatore;
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
    public final String getParola_Giocatore() {
        return parola_Giocatore;
    }

    /**
     * imposta la parola del
     * giocatore.
     * @param par_Giocatore :
     *                        la parola del giocatore
     */
    public final void setParola_Giocatore(
            final String par_Giocatore) {
        this.parola_Giocatore = par_Giocatore;
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
