package it.uniba.app.entity;

import it.uniba.app.control.Controllo;

public class Paroliere extends Utente {
    private String parola_Paroliere;
    private Controllo controllo;

    public Paroliere(int id) {
        super(id);
    }

    public Paroliere(int id, String parola_Paroliere) {
        super(id);
        this.parola_Paroliere = parola_Paroliere;
    }

    public Paroliere(int id,String parola_Paroliere,String username) {
        super(username, id);
        this.parola_Paroliere = parola_Paroliere;
    }

    public String getParola_Paroliere() {
        return parola_Paroliere;
    }

    public Controllo getControllo() {
        return controllo;
    }

    public void setControllo(Controllo controllo) {
        this.controllo = controllo;
    }

    public void impostaParola(String parola_Paroliere) {
        this.parola_Paroliere = parola_Paroliere;
    }         

}

