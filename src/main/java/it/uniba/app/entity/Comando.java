package it.uniba.app.entity;

public class Comando implements Cloneable {
    /**
     * nome :  nome comando.
     */
    private String nome;
    /**
     * utente : utente del gioco.
     */
    private final Utente utente = new Utente();
    /**
     * idNuova : codice univoco
     * per il comando /nuova.
     */
    private static final int idNuova = 1;
    /**
     * idMostra : codice univoco
     * per il comando /mostra.
     */
    private static final int idMostra = 2;
    /**
     * idHelp : codice univoco
     * per il comando /help.
     */
    private static final int idHelp = 3;
    /**
     * idGioca : codice univoco
     * per il comando /gioca.
     */
    private static final int idGioca = 4;
    /**
     * idAbbandona : codice univoco
     * per il comando /abbandona.
     */
    private static final int idAbbandona = 5;
    /**
     * indovina : codice univoco
     * per fare un tentativo.
     */
    private static final int tenta = 6;
    /**
     * idEsci : codice univoco
     * per il comando /esci.
     */
    private static final int idEsci = 7;
    /**
     * incorretto : codice univoco
     * per indicare un comando
     * invalido.
     */
    private static final int incorretto = -1;

    /**
     * costruttore della classe.
     */
    public Comando() {
        nome = "";
    }

    /**
     * costruttore.
     * @param nomeComando : nome del comando
     */
    public Comando(final String nomeComando) {
        this.nome = nomeComando;
    }

    /**
     * restituisce il nome
     * del comando.
     * @return : restituisce il nome del comando
     */
    public final String getNome() {
        return nome;
    }

    /**
     * imposta il nome
     * del comando.
     * @param nomeComando :nome del comando
     */
    public final void setNome(final String nomeComando) {
        this.nome = nomeComando;
    }

    /**
     * restituisce l'utente.
     * @return : restituisce l'Utente
     */
    public final Utente getUtente() throws CloneNotSupportedException {
        return (Utente) this.utente.clone();
    }

    /**
     * controlla il
     * comando inserito.
     * @param comando : comando da controllare
     * @return :il codice identificativo del comando
     */
    public final int controllaComando(final String comando) {
        int esito = 0;
        char[] controlloComando = comando.toCharArray();
        switch (comando) {

            case "/nuova":
                esito = idNuova;
            break;
            case "/mostra":
                esito = idMostra;
            break;
            case "/help":
                esito = idHelp;
            break;
            case "/gioca":
                esito = idGioca;
                break;
            case "/abbandona":
                esito = idAbbandona;
            break;
            case "/esci":
                esito = idEsci;
            break;
            default:
            esito = incorretto;
            break;
        }

        if (controlloComando[0] != '/') {
            esito = tenta;
        }
        return esito;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
