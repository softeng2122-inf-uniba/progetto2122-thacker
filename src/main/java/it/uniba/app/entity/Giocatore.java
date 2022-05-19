package it.uniba.app.entity;

import it.uniba.app.control.Controllo;

public class Giocatore extends Utente {
    private int nTentativi;
    private String parola_Giocatore;
    private Controllo controllo;

    public Giocatore(int id){
        super(id);
        nTentativi=-1;
    }

    public Giocatore(String username, int id, int nTentativi, String parola_Giocatore) {
        super(username, id);
        this.nTentativi = nTentativi;
        this.parola_Giocatore = parola_Giocatore;
    }

    public Giocatore(int id, int nTentativi, String parola_Giocatore) {
        super(id);
        this.nTentativi = nTentativi;
        this.parola_Giocatore = parola_Giocatore;
    }

    public int getnTentativi() {
        return nTentativi;
    }

    public void setnTentativi(int nTentativi) {
        this.nTentativi = nTentativi;
    }

    public String getParola_Giocatore() {
        return parola_Giocatore;
    }

    public void setParola_Giocatore(String parola_Giocatore) {
        this.parola_Giocatore = parola_Giocatore;
    }

    public Controllo getControllo() {
        return controllo;
    }

    public void setControllo(Controllo controllo) {
        this.controllo = controllo;
    }
   
    
    public void incrTentativi(){
        nTentativi++;
    }

    

    
}