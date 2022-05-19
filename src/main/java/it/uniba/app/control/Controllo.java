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
 


}