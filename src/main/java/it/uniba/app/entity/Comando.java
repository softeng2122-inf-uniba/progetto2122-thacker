package it.uniba.app.entity;
import java.util.*;


public class Comando {
    private String nome;
    private List<Utente> utenti = new ArrayList<>();

    public Comando(){
        nome="";
    }
    
    public Comando(String nome){
        this.nome=nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }

    public final int controllaComando(final String comando) {
        int esito = 0;
        char[] controlloComando = comando.toCharArray();
        switch (comando) {

            case "/nuova":
                esito = 1;
            break;

            case "/mostra":
                esito = 2;
            break;

            case "/help":
                esito = 3;
            break;

            case "/gioca":
                esito = 4;
            break; 
            case "/abbandona":
                esito = 5;
            break;

            case "/esci":
                esito = 7;
            break;

            default:
            esito = -1;
            break;
        }

        if (controlloComando[0] != '/') {
            esito = 6;
        }
        
        return esito;
    }
}
