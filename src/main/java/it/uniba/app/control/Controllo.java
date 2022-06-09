package it.uniba.app.control;

import java.util.regex.Pattern;

/**
 * classe che racchiude i controlli utili al funzionamento di java.
 *
 */
public class Controllo {
    /**
     * massimo numero di lettere.
     *
     */
   private final int maxNLettere;

    /**
     * Costruttore.
     * @param maxLettere :numero massimo di lettere presenti nella parola.
     *
     */
    public Controllo(final int maxLettere) {
        this.maxNLettere = maxLettere;
    }

    /**
     * ritorna il numero di
     * lettere massimo.
     * @return :restituisce il numero
     * massimo di lettere di cui è composta la parola
     */
    public final int getMaxNLettere() {
        return maxNLettere;
    }

    /**
     * controlla l'esattezza della
     * parola inserita.
     * @param parola : parola da controllare
     * @return : restituisce true se la
     * parola inserita non è
     * corretta , false altrimenti
     */
    public  final boolean controlloParola(final String parola)  {
    boolean esito = false;
    if (parola.length() < maxNLettere) {
        esito = true;
        System.out.println("\nTENTATIVO INCOMPLETO\n");
    } else if (parola.length() > maxNLettere) {
        esito = true;
        System.out.println("\nTENTATIVO ECCESSIVO\n");
    } else if (controlloCaratteri(parola)) {
        esito = true;
        System.out.println("\nTENTATIVO NON VALIDO\n");
    }
    return esito;
}
    /**
     * controlla la presenza di numeri
     * o caratteri speciali
     * all'interno della parola.
     * @param parola : parola da controllare
     * @return : restituisce true se la parola
     * non contiene caratteri
     * speciali o numeri , false altrimenti
     */
 public final boolean controlloCaratteri(final String parola) {
    boolean esito = false;
    if (!Pattern.matches("^[a-zA-Z]+$", parola)) {
        esito = true;
    }
    return esito;
 }
    /**
     *  controlla la presenza
     *  di una lettera
     *  all'interno della parola.
     * @param parolaParoliere :contiene
     *                         la parola da indovinare
     * @param lettera :  lettera
     *                da  individuare all'interno della parola segreta
     * @return : true se
     * la lettera è stata trovata ,altrimenti false
     */
 public final boolean controlloLettere(final char[]parolaParoliere,
                                       final char lettera) {
     boolean trovata = false;
     int i = 0;
     while (!trovata
             && i < parolaParoliere.length) {
         if (parolaParoliere[i] == lettera) {
            trovata = true;
         }
         i++;
     }
     return trovata;
 }

    /**
     * confronta la parola
     * del giocatore
     * con la parola del
     * paroliere.
     * @param parolaParoliere :parola segreta da indovinare
     * @param parolaGiocatore : parola inserita dal giocatore
     * @param esiti : matrice che indica la
     *              correttezza  o l'assenza
     *              delle lettere all'interno della parola
     * @param maxTentativi : numero di
     *                      tentativi massimo che il giocatore
     *                      ha per indovinare la parola segreta
     * @param nTentativo : indica il
     *                   numero di tentativo corrente
     */
 public final void controllaParola(final char[] parolaParoliere,
                                   final char[]parolaGiocatore,
                                   final int[][] esiti,
                                   final int maxTentativi,
                                   final int nTentativo) {
     for (int i = 0; i < parolaGiocatore.length; i++) {
         if (parolaGiocatore[i]
                 == parolaParoliere[i]) {
             esiti[nTentativo][i] = 0;
         } else {
           if (controlloLettere(parolaParoliere,
                   parolaGiocatore[i])) {
              esiti[nTentativo][i] = 1;
          } else {
              esiti[nTentativo][i] = 2;
          }
         }
     }
 }

    /**
     * metodo che stampa l'help dei comandi.
     */
 public final void stampaHelp() {
        System.out.println("  +--------------------------"
                + "----------------------------------+");
        System.out.println("  |                       WORDLE -"
               + " HELP                        |");
        System.out.println("  +--------------------------"
                + "----------------------------------+");
        System.out.println("  |/esci --> Con questo "
                + "comando viene chiuso il gioco          |");
        System.out.println("  +---------------------------"
                + "---------------------------------+");
        System.out.println("  |/nuova <parola> "
               + "--> Con questo comando andremo a            |");
        System.out.println("  |          inserire una "
                + "nuova parola segreta                 |");
        System.out.println("  +---------------------------"
                + "---------------------------------+");
        System.out.println("  |/gioca--> Con questo comando "
                + "verrà avvaiata la partita      |");
        System.out.println("  | e mostrata la matrice dei"
                + " tentativi vuota e si viene       |");
        System.out.println("  |preddisposti a ricevere"
                + " il primo tentativo o altri comandi  |");
        System.out.println("  +----------------------------"
                + "--------------------------------+");
        System.out.println("  |/mostra--> Con questo "
                + "comando l'applicazione risponde       |");
        System.out.println("  |mostrando la parola segreta "
                + "                                |");
        System.out.println("  +---------------------------"
                + "---------------------------------+");
        System.out.println("  |/abbandona --> Con  questo "
                + "comando l'applicazione chiederà  |");
        System.out.println("  |una conferma  che se risulterà"
               + " positiva porterà, l'abbando  |");
        System.out.println("  |della partita , se risulterà"
                + " negativa l'applicazione sarà   |");
        System.out.println("  |predisposta a ricevere un"
               + " altro tebtativo o altri comandi   |");
        System.out.println("  +------------------------------"
                + "------------------------------+");
        System.out.println("  |/esci --> Con  questo comando "
                + "se la conferma è postiva l'app|");
        System.out.println("  | verrà chiusa         "
                + "                                      |");
        System.out.println("  +---------------------------"
                + "---------------------------------+");
        System.out.println("  |<parola> --> Con questo comando "
                + "verranno mostrati 3 tipi di |");
        System.out.println("  | messaggi               "
                + "                                    |");
        System.out.println("  | _ INCOMPLETO :  se i caratteri"
                + " sono inferiori a quelli     |");
        System.out.println("  |della parola segreta           "
                + "                             |");
        System.out.println("  |_ ECCESSIVO : se  i caratteri"
                + " sono superiori a quelli dellla|");
        System.out.println("  |parola segreta              "
                + "                                |");
        System.out.println("  | _ NON VALIDO : se i caratteri"
                + " non corrispondono a lettere  |");
        System.out.println("  |dell'alfabeto                "
                + "                               |");
        System.out.println("  +---------------------------"
               + "---------------------------------+");
 }

    /**
     * restituisce la
     * matrice di caratteri.
     * @param righe : righe della matrice
     * @param colonne : colonne della matrice
     * @return : restituisce la matrice vuota
     */
    public final char[][] getMatrice(final int righe,
                                     final int colonne) {
    char[][] matrice = new char[righe][colonne];

    for (int i = 0; i < righe; i++) {
        for (int j = 0; j < colonne; j++) {
            matrice[i][j] = '-';
        }
    }
    return matrice;
 }

    /**
     * stampa la matrice.
     * @param matrice : matrice contenente
     *                la parole inserite dal giocatore
     * @param righe : righe della matrice
     * @param colonna : colonne della matrice
     */
    public final void stampaMatrice(final char[][] matrice,
                                    final int righe,
                                    final int colonna) {
     for (int i = 0; i < righe; i++) {
        for (int j = 0; j < colonna; j++) {
            System.out.print("\t" + matrice[i][j]);
        }
            System.out.print("\n");
        }
 }
    /**
     * restituisce una matrice
     * di interi.
     * @param righe : righe della matrice esiti
     * @param colonne : colonne della matrice esiti
     * @return : matrice vuota di interi ,
     * con tutte le celle inizializzate a -1
     */
 public final int[][] getMatriceInt(final int righe,
                                    final int colonne) {
     int[][] matrice = new int[righe][colonne];

     for (int i = 0; i < righe; i++) {
         for (int j = 0; j < colonne; j++) {
             matrice[i][j] = -1;
         }
     }
  return matrice;
 }

    /**
     * stampa la matrice
     * colorata.
     * @param matrice :matrice contenete
     *                le parole inserite dal giocatore
     * @param esiti : matrice che indica la
     *              correttezza  o l'assenza
     *              delle lettere all'interno della parola
     * @param righe : righe della matrice
     * @param colonne : colonne della matrice
     */
 public final void stampaMatriceColorata(final char[][]matrice,
                                         final int[][]esiti,
                                         final int righe,
                                         final int colonne) {
       final String ansiRESET =
               "\u001B[40m";
       final String ansiGREENBACKGROUND =
               "\u001B[42m";
       final String ansiYELLOWBACKGROUND =
               "\u001B[43m";
       final String ansiWHITEBACKGROUND =
               "\u001B[47m";
       for (int i = 0; i < righe; i++) {
           for (int j = 0; j < colonne; j++) {
               if (esiti[i][j] == 0) {
                  System.out.print("\t"
                          + ansiGREENBACKGROUND
                          + matrice[i][j]
                          + ansiRESET);
               } else {
                if (esiti[i][j] == 1) {
                       System.out.print("\t"
                               + ansiYELLOWBACKGROUND
                               + matrice[i][j]
                               + ansiRESET);
                   } else {
                       if (esiti[i][j] == 2) {
                           System.out.print("\t"
                                   + ansiWHITEBACKGROUND
                                   + matrice[i][j]
                                   + ansiRESET);
                       } else {
                           System.out.print("\t"
                                   + ansiRESET
                                   + matrice[i][j]
                                   + ansiRESET);
                       }
                }
               }
           }
           System.out.println("\n");
       }
 }
}
