package it.uniba.app.entity;
import java.util.List;
import java.util.ArrayList;

public class Comando {
    /**
     * nome :  nome comando
     */
    private String nome;
    /**
     * utenti : lista di utenti
     */
    private List<Utente> utenti = new ArrayList<>();

    /**
     * costruttore della classe
     */
    public Comando() {
        nome = "";
    }

    /**
     *
     * @param nome : nome del comando
     */
    public Comando(final String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return : restituisce il nome del comando
     */
    public final String getNome() {
        return nome;
    }

    /**
     *
     * @param nome :nome del comando
     */
    public final void setNome(final String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return : restituisce la lista di utenti
     */
    public final List<Utente> getUtenti() {
        return utenti;
    }

    /**
     *
     * @param utenti : lista utenti
     */
    public final void setUtenti(final List<Utente> utenti) {
        this.utenti = utenti;
    }

    /**
     * @param comando : comando da controllare
     * @return :il codice identificativo del comando
     */
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
