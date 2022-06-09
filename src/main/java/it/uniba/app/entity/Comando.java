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
    private static final int IDNUOVA = 1;
    /**
     * idMostra : codice univoco
     * per il comando /mostra.
     */
    private static final int IDMOSTRA = 2;
    /**
     * idHelp : codice univoco
     * per il comando /help.
     */
    private static final int IDHELP = 3;
    /**
     * idGioca : codice univoco
     * per il comando /gioca.
     */
    private static final int IDGIOCA = 4;
    /**
     * idAbbandona : codice univoco
     * per il comando /abbandona.
     */
    private static final int IDABBANDONA = 5;
    /**
     * indovina : codice univoco
     * per fare un tentativo.
     */
    private static final int TENTA = 6;
    /**
     * idEsci : codice univoco
     * per il comando /esci.
     */
    private static final int IDESCI = 7;
    /**
     * incorretto : codice univoco
     * per indicare un comando
     * invalido.
     */
    private static final int INCORRETTO = -1;

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
                esito = IDNUOVA;
            break;
            case "/mostra":
                esito = IDMOSTRA;
            break;
            case "/help":
                esito = IDHELP;
            break;
            case "/gioca":
                esito = IDGIOCA;
                break;
            case "/abbandona":
                esito = IDABBANDONA;
            break;
            case "/esci":
                esito = IDESCI;
            break;
            default:
            esito = INCORRETTO;
            break;
        }

        if (controlloComando[0] != '/') {
            esito = TENTA;
        }
        return esito;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
