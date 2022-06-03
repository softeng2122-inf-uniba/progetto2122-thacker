package it.uniba.app.control;

import java.util.regex.Pattern;

/**
 * classe che racchiude i controlli utili al funzionamento di java
 */
public class Controllo {
   private final int max_NLettere;

    /**
     *
     * @param max_NLettere :numero massimo di lettere presenti nella parola
     */
    public Controllo(final int max_NLettere) {
        this.max_NLettere = max_NLettere;
    }

    /**
     *
     * @return :restituisce il numero massimo di lettere di cui è composta la parola
     */
    public final int getMax_NLettere() {
    return max_NLettere;
    }

    /**
     *
      * @param parola : parola da controllare
     * @return : restituisce true se la parola inserita non è corretta , false altrimenti
     */
    public  final boolean controlloParola(final String parola)  {

    boolean esito = false;
    if (parola.length() < max_NLettere) {
        esito = true;
        System.out.println("\nTENTATIVO INCOMPLETO\n");
    } else if (parola.length() > max_NLettere) {
        esito = true;
        System.out.println("\nTENTATIVO ECCESSIVO\n");
    } else if (controlloCaratteri(parola) == true) {
        esito = true;
        System.out.println("\nTENTATIVO NON VALIDO\n");
    }
    return esito;
}
    /**
     *
     * @param parola : parola da controllare
     * @return : restituisce true se la parola non contiene caratteri speciali o numeri , false altrimenti
     */
 public final boolean controlloCaratteri(final String parola) {
    boolean esito = false;
    if (!Pattern.matches("^[a-zA-Z]+$", parola)) {
        esito = true;
    }
    return esito;
 }
    /**
     *
      * @param parola_paroliere :contiene la parola da indovinare
     * @param lettera :  lettera da  individuare all'interno della parola segreta
     * @return : true se la lettera è stata trovata ,altrimenti false
     */
 public final boolean controlloLettere(final char[]parola_paroliere, final char lettera) {
     boolean trovata = false;
     int i = 0;
     while (trovata != true && i < parola_paroliere.length) {
         if (parola_paroliere[i] == lettera) {
            trovata = true;
         }
         i++;
     }
     return trovata;
 }

    /**
     *
     * @param parola_paroliere :parola segreta da indovinare
     * @param parola_giocatore : parola inserita dal giocatore
     * @param esiti : matrice che indica la correttezza  o l'assenza delle lettere all'interno della parola
     * @param max_tentativi : numero di tentativi massimo che il giocatore ha per indovinare la parola segreta
     * @param nTentativo : indica il numero di tentativo corrente
     */
 public final void controllaParola(final char[] parola_paroliere, final char[]parola_giocatore, final int[][] esiti, final int max_tentativi, final int nTentativo) {
     for (int i = 0; i < parola_giocatore.length; i++) {
         if (parola_giocatore[i] == parola_paroliere[i]) {
             esiti[nTentativo][i] = 0;
         } else {
           if (controlloLettere(parola_paroliere, parola_giocatore[i]) == true) {
              esiti[nTentativo][i] = 1;
          } else {
              esiti[nTentativo][i] = 2;
          }
         }
     }
 }

    /**
     * metodo che stampa l'help dei comandi
     */
 public final void stampaHelp() {
        System.out.println("  +------------------------------------------------------------+");
        System.out.println("  |                       WORDLE - HELP                        |");
        System.out.println("  +------------------------------------------------------------+");
        System.out.println("  |/esci --> Con questo comando viene chiuso il gioco          |");
        System.out.println("  +------------------------------------------------------------+");
        System.out.println("  |/nuova <parola> --> Con questo comando andremo a            |");
        System.out.println("  |          inserire una nuova parola segreta                 |");
        System.out.println("  +------------------------------------------------------------+");
        System.out.println("  |/gioca--> Con questo comando verrà avvaiata la partita      |");
        System.out.println("  | e mostrata la matrice dei tentativi vuota e si viene       |");
        System.out.println("  |preddisposti a ricevere il primo tentativo o altri comandi  |");
        System.out.println("  +------------------------------------------------------------+");
        System.out.println("  |/mostra--> Con questo comando l'applicazione risponde       |");   
        System.out.println("  |mostrando la parola segreta                                 |");
        System.out.println("  +------------------------------------------------------------+");
        System.out.println("  |/abbandona --> Con  questo comando l'applicazione chiederà  |");
        System.out.println("  |una conferma  che se risulterà positiva porterà, l'abbando  |");
        System.out.println("  |della partita , se risulterà negativa l'applicazione sarà   |");
        System.out.println("  |predisposta a ricevere un altro tebtativo o altri comandi   |");
        System.out.println("  +------------------------------------------------------------+");
        System.out.println("  |/esci --> Con  questo comando se la conferma è postiva l'app|");
        System.out.println("  | verrà chiusa                                               |");
        System.out.println("  +------------------------------------------------------------+");
        System.out.println("  |<parola> --> Con questo comando verranno mostrati 3 tipi di |");
        System.out.println("  | messaggi                                                   |");
        System.out.println("  | _ INCOMPLETO :  se i caratteri sono inferiori a quelli     |");
        System.out.println("  |della parola segreta                                        |");
        System.out.println("  |_ ECCESSIVO : se  i caratteri sono superiori a quelli dellla|");
        System.out.println("  |parola segreta                                              |");
        System.out.println("  | _ NON VALIDO : se i caratteri non corrispondono a lettere  |");
        System.out.println("  |dell'alfabeto                                               |");
        System.out.println("  +------------------------------------------------------------+");
 }

    /**
     *
     * @param righe : righe della matrice
     * @param colonne : colonne della matrice
     * @return: restituisce la matrice vuota
     */
    public final char[][] getMatrice(final int righe, final int colonne) {
    char[][] matrice = new char[righe][colonne];

    for (int i = 0; i < righe; i++) {
        for (int j = 0; j < colonne; j++) {
            matrice[i][j] = '-';
        }
    }
    return matrice;
 }

    /**
     *
     * @param matrice : matrice contenente la parole inserite dal giocatore
     * @param righe : righe della matrice
     * @param colonna : colonne della matrice
     */
    public final void stampaMatrice(final char[][] matrice, final int righe, final int colonna) {
     for (int i = 0; i < righe; i++) {
        for (int j = 0; j < colonna; j++) {
            System.out.print("\t" + matrice[i][j]);
        }
            System.out.print("\n");
        }
 }
    /**
     *
     * @param righe : righe della matrice esiti
     * @param colonne : colonne della matrice esiti
     * @return : matrice vuota di interi , con tutte le celle inizializzate a -1
     */
 public final int[][] getMatriceInt(final int righe, final int colonne) {
     int[][] matrice = new int[righe][colonne];

     for (int i = 0; i < righe; i++) {
         for (int j = 0; j < colonne; j++) {
             matrice[i][j] = -1;
         }
     }
  return matrice;
 }

    /**
     *
     * @param matrice :matrice contenete le parole inserite dal giocatore
     * @param esiti : matrice che indica la correttezza  o l'assenza delle lettere all'interno della parola
     * @param righe : righe della matrice
     * @param colonne : colonne della matrice
     */
 public final void stampaMatriceColorata(final char[][]matrice, final int[][]esiti, final int righe, final int colonne) {
       final String ANSI_RESET = "\u001B[40m";
       final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
       final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
       final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
       for (int i = 0; i < righe; i++) {
           for (int j = 0; j < colonne; j++) {
               if (esiti[i][j] == 0) {
                  System.out.print("\t" + ANSI_GREEN_BACKGROUND + matrice[i][j] + ANSI_RESET);
               } else {
                if (esiti[i][j] == 1) {
                       System.out.print("\t" + ANSI_YELLOW_BACKGROUND + matrice[i][j] + ANSI_RESET);
                   } else {
                       if (esiti[i][j] == 2) {
                           System.out.print("\t" + ANSI_WHITE_BACKGROUND + matrice[i][j] + ANSI_RESET);
                       } else {
                           System.out.print("\t" + ANSI_RESET + matrice[i][j] + ANSI_RESET);
                       }
                   }
               }
             } 
           System.out.println("\n");
       }
 }
}
