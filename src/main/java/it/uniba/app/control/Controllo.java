package it.uniba.app.control;

import java.awt.Color;
import java.util.regex.Pattern;
import java.io.*;

public class Controllo {
   private int max_NLettere;

public Controllo(int max_NLettere) {
    this.max_NLettere = max_NLettere;
}

public int getMax_NLettere() {
    return max_NLettere;
}

public void setMax_NLettere(int max_NLettere) {
    this.max_NLettere = max_NLettere;
}


public boolean controlloParola(String parola) {

    boolean esito = false;
    if(parola.length() < max_NLettere){
        esito = true;
        System.out.println("Parola troppo corta\n");
    }else if(parola.length() > max_NLettere) {
        esito = true;
        System.out.println("Parola troppo lunga\n");
    }else if(controlloCaratteri(parola)==true){
        esito=true;
        System.out.println("Nella parola sono presenti caratteri non validi\n");
    }

    return esito;
}

 public boolean controlloCaratteri(String parola){
    boolean esito = false;

    if(!Pattern.matches("^[a-zA-Z]+$", parola))
    {
        esito=true;
    }

    return esito;

 }

    
 public boolean controlloLettere(char[]parola_paroliere, char lettera)
 {
     boolean trovata=false;
     int i=0;
     
     while(trovata != true && i<parola_paroliere.length){
         if(parola_paroliere[i]== lettera)
         {
            trovata=true;
         }
         i++;
     }
    
     return trovata;
 }
 
 public void controllaParola(char[] parola_paroliere, char[]parola_giocatore,int[][] esiti,int max_tentativi,int nTentativo)
 {
     for(int i=0;i<parola_giocatore.length;i++)
     {
         if(parola_giocatore[i] == parola_paroliere[i])
         {
             
             esiti[nTentativo][i]= 0;
             
         }
         else
         {
          if(controlloLettere(parola_paroliere, parola_giocatore[i])== true)
          {
              esiti[nTentativo][i]=1;
          }else
          {
              esiti[nTentativo][i]=2;
          }
         }
     }

 }
 
 public void stampaHelp(){
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
        System.out.println("  |/indovina --> Con questo comando verranno mostrati 3 tipi di|");
        System.out.println("  | messaggi                                                   |");
        System.out.println("  | _ INCOMPLETO :  se i caratteri sono inferiori a quelli     |");
        System.out.println("  |della parola segreta                                        |");
        System.out.println("  |_ ECCESSIVO : se  i caratteri sono superiori a quelli dellla|");
        System.out.println("  |parola segreta                                              |");
        System.out.println("  | _ NON VALIDO : se i caratteri non corrispondono a lettere  |");
        System.out.println("  |dell'alfabeto                                               |");
        System.out.println("  +------------------------------------------------------------+");
 }

public char[][] getMatrice(int righe,int colonne)
 {
    char[][] matrice = new char[righe][colonne];

    for(int i=0;i<righe;i++){
        for(int j=0;j<colonne;j++){
            matrice[i][j]='-';
        }
    }

    return matrice;    
 }

public void stampaMatrice(char[][] matrice,int righe,int colonna){
     for(int i=0;i<righe;i++){
        for(int j=0;j<colonna;j++){
            System.out.print("\t"+matrice[i][j]);
        }
            System.out.print("\n");

        }
 }

 public int[][] getMatriceInt(int righe,int colonne)
 {
     int[][] matrice = new int[righe][colonne];

     for(int i=0;i<righe;i++){
         for(int j=0;j<colonne;j++){
             matrice[i][j]=-1;
         }
     }

     return matrice;
 }

 public void stampaMatriceColorata(char[][]matrice,int[][]esiti,int righe,int colonne){
       final String ANSI_RESET = "\u001B[40m";
       final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
       final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
       final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
       
       for(int i=0;i<righe;i++){
           for(int j=0;j<colonne;j++){
               if(esiti[i][j]==0)
               {
                   
                  System.out.print("\t"+ ANSI_GREEN_BACKGROUND + matrice[i][j] + ANSI_RESET);
               }
               else{
                   if(esiti[i][j]==1)
                   {
                       System.out.print("\t"+ ANSI_YELLOW_BACKGROUND + matrice[i][j] + ANSI_RESET);
                   }
                   else
                   {
                       if(esiti[i][j]==2){
                           System.out.print("\t"+ ANSI_WHITE_BACKGROUND + matrice[i][j] + ANSI_RESET);
                       }else
                       {
                           System.out.print("\t"+ ANSI_RESET + matrice[i][j] + ANSI_RESET);
                       }

                   }
               }


           }
           System.out.println("\n");
       }
       
       
 }
 


}