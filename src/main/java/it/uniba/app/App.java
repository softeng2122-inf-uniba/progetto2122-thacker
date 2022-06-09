package it.uniba.app;

import java.util.Scanner;
import it.uniba.app.control.Controllo;
import it.uniba.app.entity.Comando;
import it.uniba.app.entity.Giocatore;
import it.uniba.app.entity.Paroliere;


public final class App {

    //not call
    private App() { }

    /**
     * Main del gioco.
     * @param args
     */
    public static void main(final String[] args) {
            Scanner in = new Scanner(System.in, "UTF-8");
            final int maxLettere = 5;
            final int maxTentativi = 6;
            final int maxTent = 5;
            final int idNuova = 1;
            final int idMostra = 2;
            final int idHelp = 3;
            final int idGioca = 4;
            final int idAbbandona = 5;
            final int tenta = 6;
            final int idEsci = 7;
            Paroliere paroliere = new Paroliere(0);
            Giocatore giocatore = new Giocatore(0);
            Comando comando = new Comando();
            Controllo controllo = new Controllo(maxLettere);
            char[][] matrice = controllo.getMatrice(maxTentativi, maxLettere);
            int[][] esiti = controllo.getMatriceInt(maxTentativi, maxLettere);
            String comandoUtente;
            String[] comandoCorrente;
            String rispostaUtente;
            boolean partitaInCorso = false; // non è in corso
            int checkComando = 0;
            String parola;
            
            System.out.println("\n\nBENVENUTI IN WORDLE!");
            while (checkComando != idEsci) {
                System.out.println("Inserisci comando...\n");
                comandoUtente = in.nextLine();
                comandoCorrente = comandoUtente.split(" ");
                checkComando = comando.controllaComando(comandoCorrente[0]);
                switch (checkComando) {
                    case idNuova:
                        try {
                            if (!controllo.
                                    controlloParola(comandoCorrente[1])) {
                            paroliere.impostaParola(comandoCorrente[1]);
                            paroliere.impostaParola(comandoCorrente[1].toLowerCase());
                            } else {
                                System.out.println("Reinserire la parola\n");
                                }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Ops! Hai "
                                    + "dimenticato di inserire la parola\n");
                        }
                        break;
                    case idMostra:
                        if (paroliere.getParolaParoliere() != null) {
                             System.out.println("La parola segreta è: "
                                     + paroliere.getParolaParoliere());
                        } else  {
                            System.out.print("Non è stata "
                                    + "inserita nessuna parola");
                        }
                    break;

                    case idHelp:
                        controllo.stampaHelp();
                    break;

                    case idGioca:
                    if (!partitaInCorso) {
                        matrice = controllo.getMatrice(maxTentativi,
                                maxLettere);
                        giocatore.setnTentativi(-1);

                        controllo.stampaMatrice(matrice, maxTentativi,
                                maxLettere);

                        checkComando = 0;
                        System.out.println("\n Ora inizia una nuova partita!\n "
                                + "Paroliere inserisci una nuova"
                                + " parola con l'apposito comando!\n");

                        partitaInCorso = true;
                        paroliere.impostaParola("");
                    } else {
                        System.out.println("E' in corso un'altra partita \n");
                        checkComando = 0;
                    }
                    break;
                    case idAbbandona:
                        System.out.println("Vuoi abbandonare "
                                + "la partita? SI/NO");
                        rispostaUtente = in.nextLine();
                        if (rispostaUtente.compareToIgnoreCase("SI") == 0) {
                            System.out.println("Partita abbandonata!");
                            partitaInCorso = false;
                            esiti = controllo.getMatriceInt(maxTentativi,
                                    maxLettere);
                            matrice = controllo.getMatrice(maxTentativi,
                                    maxLettere);
                            paroliere.impostaParola("");
                        } else {
                            checkComando = 0;
                        }
                    break;
                    case tenta:
                       try {
                            if (!controllo.
                                    controlloParola(comandoCorrente[0])) {
                                if (paroliere.getParolaParoliere() != null) {
                                    if (giocatore.getnTentativi() != maxTent) {
                                        char[] parolaParoliere =
                                                paroliere.
                                                        getParolaParoliere().
                                                        toCharArray();
                                                parola = comandoCorrente[0].
                                                toLowerCase();
                                        char[] parolaGiocatore =
                                                parola.toCharArray();
                                        giocatore.incrTentativi();

                                        controllo.
                                                controllaParola(
                                                        parolaParoliere,
                                                        parolaGiocatore,
                                                        esiti,
                                                        maxTentativi,
                                                        giocatore.
                                                                getnTentativi());

                                        for (int i = 0; i < maxLettere; i++)  {
                                            if (esiti[giocatore.
                                                    getnTentativi()][i]
                                                    == 0) {
                                                System.out.
                                                        println("Lettera: "
                                                        + parolaGiocatore[i]
                                                        + " presente");
                                                matrice[giocatore.
                                                        getnTentativi()][i] =
                                                        parolaGiocatore[i];
                                            } else {
                                                if (esiti[giocatore.
                                                        getnTentativi()][i]
                                                        == 1) {
                                                    System.out.
                                                            println("Lettera: "
                                                            + parolaGiocatore[i]
                                                            + " presente,ma "
                                                                    + "non "
                                                            + "in posizione "
                                                                    + "giusta");
                                                    matrice[giocatore.
                                                            getnTentativi()][i]
                                                            = parolaGiocatore[i];
                                                } else {
                                                    System.out.
                                                            println("Lettera: "
                                                            + parolaGiocatore[i]
                                                            + " NON PRESENTE ");
                                                    matrice[giocatore.
                                                            getnTentativi()][i]
                                                            =
                                                            parolaGiocatore[i];
                                                }
                                            }
                                        }

                                        controllo.
                                                stampaMatriceColorata(matrice,
                                                        esiti,
                                                        maxTentativi,
                                                        maxLettere);
                                        System.out.
                                                println("\nTENTATIVI:"
                                                + (giocatore.
                                                        getnTentativi() + 1));
                                        boolean indovinata = true;
                                        for (int i = 0; i < maxLettere; i++) {
                                            if (esiti[giocatore.
                                                    getnTentativi()][i]
                                                    != 0) {
                                                indovinata = false;
                                                i = maxLettere;
                                            }
                                        }
                                        if (indovinata) {
                                            System.out.
                                                    println("PAROLA "
                                                            + "INDOVINATA!");
                                            partitaInCorso
                                                    = false;
                                        }
                                        if (giocatore.
                                                getnTentativi() == maxTent) {
                                            System.out.println("------------"
                                                    + "-------"
                                                    + "------------------------"
                                                    + "--------"
                                                    + "------");
                                            controllo.
                                                    stampaMatriceColorata(
                                                            matrice,
                                                    esiti,
                                                    maxTentativi,
                                                    maxLettere);
                                            System.out.
                                                    println("\nTENTATIVI:"
                                                    + (giocatore.
                                                            getnTentativi()
                                                            + 1));
                                            System.out.
                                                    println("TENTATIVI "
                                                            + "ESAURITI! \n"
                                                    + "La parola "
                                                            + "segreta e':"
                                                    + paroliere.
                                                            getParolaParoliere());
                                            System.out.println("-----"
                                                    + "----"
                                                    + "----------------"
                                                    + "----------------"
                                                    + "----------------");
                                            partitaInCorso = false;
                                        }
                                    }
                                } else {
                                    System.out.println("Il paroliere non ha "
                                            + "inserito la parola "
                                            + "da indovinare\n"
                                            + "Può farlo con "
                                            + "l'apposito comando\n");
                                }
                            } else {
                             System.out.println("Reinserire la parola\n");
                            }
                       } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Ops! Hai dimenticato"
                                    + " di inserire la parola\n");
                       }
                    break;

                    case idEsci:
                         System.out.println("Vuoi chiudere il gioco? SI/NO");
                            rispostaUtente = in.nextLine();
                            if (rispostaUtente.compareToIgnoreCase("SI")
                                == 0) {
                                System.out.println("Arrivederci!");
                                System.out.println("Chiusura del gioco...");
                            } else {
                                checkComando = 0;
                            }
                    break;

                    case 0: break;
                    default: System.out.println("Comando "
                            + "non valido");
                    break;
                }
            }
            in.close();
    }
}
