package it.uniba.app.entity;

public class Utente {
    /**
     * comando: Oggetto comando
     */
    private Comando comando;
    /**
     * username: username utente
     */
    private String username;
    /**
     * id: id utente
     */
    private int id;

    /**
     *
     * @param username : username dell'utente
     * @param id : id dell'utente
     */
    public Utente(final String username, final int id) {
        this.username = username;
        this.id = id;
    }

    /**
     *
     * @param id : id dell'utente
     */
    public Utente(final int id) {
        this.id = id;
    }

    /**
     *
     * @return : restituisce  l'username dell'utente
     */
    public final String getUsername() {
        return username;
    }

    /**
     *
     * @param username : username dell'utente
     */
    public final void setUsername(final String username) {
        this.username = username;
    }

    /**
     *
     * @return restituisce l'id
     */
    public final int getId() {
        return id;
    }

    /**
     *
     * @param id : id dell'utente
     */
    public final void setId(final int id) {
        this.id = id;
    }

    /**
     *
     * @return oggetto comando
     */
    public final Comando getComando() {
        return comando;
    }

    /**
     *
     * @param comando : oggetto comando
     */
    public final void setComando(final Comando comando) {
        this.comando = comando;
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true; }
        if (obj == null) {
            return false; }
        if (getClass() != obj.getClass()) {
            return false; }
        Utente other = (Utente) obj;
        if (id != other.id) {
            return false; }
        return true;
    }
}
