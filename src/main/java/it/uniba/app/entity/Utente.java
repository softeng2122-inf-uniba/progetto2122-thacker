package it.uniba.app.entity;

public class Utente implements Cloneable {
    /**
     * username: username utente.
     */
    private String username;
    /**
     * id: id utente.
     */
    private int id;

    /**
     * costruttore.
     * @param userName : username dell'utente
     * @param idUser : id dell'utente
     */
    public Utente(final String userName, final int idUser) {
        this.username = userName;
        this.id = idUser;
    }

    /**
     * costruttore vuoto.
     */
    public Utente() { };

    /**
     * costruttore.
     * @param idUser : id dell'utente
     */
    public Utente(final int idUser) {
        this.id = idUser;
    }

    /**
     * restituisce
     * l'username.
     * @return : restituisce  l'username dell'utente
     */
    public final String getUsername() {
        return username;
    }

    /**
     * imposta l'username.
     * @param userName : username dell'utente
     */
    public final void setUsername(final String userName) {
        this.username = userName;
    }

    /**
     * restituisce
     * l'id.
     * @return restituisce l'id
     */
    public final int getId() {
        return id;
    }

    /**
     * imposta l'id.
     * @param idUser : id dell'utente
     */
    public final void setId(final int idUser) {
        this.id = idUser;
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
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Utente other = (Utente) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
    @Override
    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
