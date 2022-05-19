package it.uniba.app;

/**
 * Main class of the application.
 */
import java.util.Scanner;

import it.uniba.app.control.Controllo;
import it.uniba.app.entity.Comando;
import it.uniba.app.entity.Giocatore;
import it.uniba.app.entity.Paroliere;

 
/**
 * Main class of the application.
 */
public final class App {
 
    public static void main(String args[]) 
    {   
            
            Scanner in = new Scanner(System.in);
            int max_Lettere = 5;
            int max_tentativi = 6;

 
            Paroliere paroliere = new Paroliere(0);
            Giocatore giocatore = new Giocatore(0);
            Comando comando = new Comando();
            Controllo controllo = new Controllo(max_Lettere);
 
            char[][] matrice = controllo.getMatrice(max_tentativi,max_Lettere);
            int[][] esiti = controllo.getMatriceInt(max_tentativi,max_Lettere);
            String comandoUtente;
            String comandoCorrente[] = new String[2];
            String rispostaUtente;
            boolean partitaInCorso = false; // non è in corso
            int checkComando=0;

            controllo.stampaHelp();
           
            while(checkComando!=7)
            {
                System.out.println("Inserisci comando...\n");
                comandoUtente = in.nextLine();
                comandoCorrente = comandoUtente.split(" ");
                checkComando = comando.controllaComando(comandoCorrente[0]);
                                
                switch (checkComando) {
                    case 1:
                        try{
                            if(controllo.controlloParola(comandoCorrente[1])==false){
                            paroliere.impostaParola(comandoCorrente[1]);
                            
                            }
                            else{
                             System.out.println("Reinserire la parola\n"); 
                                }
                        }catch(ArrayIndexOutOfBoundsException e){
                            System.out.println("Ops! Hai dimenticato di inserire la parola\n");
                        }
                   
                        break;
 
                    case 2:
                    if(paroliere.getParola_Paroliere()!= null){
                        System.out.println("La parola segreta è: " + paroliere.getParola_Paroliere());
                   }
                   else{
                       System.out.print("Non è stata inserita nessuna parola");
                   }
                       
                       
                    break;

                    case 3:
                    controllo.stampaHelp();

                       
                    break;

                    case 4:
                        
                        
                    break;

                    case 5:
                        
                    
                    break;

                    case 6:
                       
                       
                   
                    break;

                    case 7:
                        
                    break;

                    case 0:
                    break;
                
                    default:
                        System.out.println("Comando non valido");
                    break;
                }
 
            }   
 
            in.close();
    }
   
}
