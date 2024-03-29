# Report
# 1. Introduzione
La seguente relazione tecnica è relativa alla creazione del gioco di parole chiamato Wordle, ispirato all'omonimo gioco presente sul sito The New York Time, pubblicato da Josh Wardle nel 2021. In termini pratici, l'obiettivo del gioco è quello di indovinare una parola nascosta formata da un numero di lettere prestabilito, solitamente cinque, in un numero massimo di tentativi, anch'esso deciso in precedenza (solitamente 6). 
In questo gioco esistono due ruoli fondamentali, ovvero il paroliere e il giocatore. Il paroliere ha il compito di andare ad impostare nel gioco una parola segreta che il giocatore dovrà indovinare mentre il giocatore dovrà appunto cercare di indovinare la parola entro il numero di tentativi stabiliti. Nel gioco originale:
1)  Se una lettera diventa verde vuol dire che abbiamo indovinato la sua posizione nella parola. 
2)  Se è gialla significa che quella lettera è inclusa nella parola ma non nella posizione giusta. 
3) Se è grigia significa che non compare nella parola. 

La realizzazione del gioco è stata suddivisa in 3 sprint diversi. A partire dallo Sprint 0 fino ad arrivare allo Sprint 2. È stato adottato lo sviluppo agile e sono stati seguiti i 12 principi stabiliti dal framework di sviluppo Scrum. Il progetto è stato sviluppato tramite il linguaggio Java con l’aiuto della piattaforma GitHub per la creazione di un repository apposito per il progetto per il corso di Ingegneria del Software.

# 2. Modello di dominio
![concettuale](./img/concettuale.png)
# 3. Requisiti specifici
### **3.1 Requisiti funzionali**
Per ogni user story devono essere soddisfatti i seguenti requisiti 

1) C'è un issue con label «user story» 

2) In ogni issue è presente  un Milestone e  una Project Board 

3) Assegnazione a uno o al più due componenti del team 

4) Ogni classe è preceduta da un commento che riassume la responsabilità    della classe 

5) Ogni classe è preceduta da un commento per indicare se è di tipo <<Entity>>, <<Control>>, <<Boundary>>, <<noECB>> 

6) i commenti iniziano con /** e terminano con with */ 

7) I commit devono avere una descrizione breve ma significativa 

8) C'è una Pull Request (PR) che corrisponde alla user story 

9) La PR è in un Milestone ma non in una Project Board 

10) C'è un commento che linka la PR all'issue (es. "closes #22") 

11) La PR è accettata a review avvenuto ed esplicito 

12) Build costruito con successo

13) Docker image caricata con successo 

14) L'esecuzione rispetta i criteri di accettazione 
 
### **3.2 Requisiti non funzionali**

Nel progetto avremo i seguenti requisiti non funzionali: 

1) RNF1: il container docker dell’app deve essere eseguito da terminali che supportano Unicode con encoding UTF-8 o UTF-16. 

2) Elenco di terminali supportati 

    Linux: 
    - Terminal 

    Mac OS: 
    - Terminal

    Windows: 
    - Powershell 
    - Git Bash (in questo caso il comando Docker ha come prefisso winpty; es: winpty docker -it ....) 

Comando per l’esecuzione del container 
Dopo aver eseguito il comando docker pull copiandolo da GitHub Packages, Il comando Docker da usare per eseguire il container contenente l’applicazione è: 

docker run --rm -it ghcr.io/softeng2122-inf-uniba/wordle-base2122:latest 
dove base2122 sarà sostitituito con il nome del gruppo. 

# 4. System Design

Il system design non è stato descritto in modo dettagliato in quanto il nostro progetto è di piccole dimensioni, ma è stato fatto il diagramma dei pacchetti.

![Pacchetti](./img/Pacchetti.jpg)

# 5. OO Design

Dopo un’attenta analisi dei requisiti funzionali, abbiamo trovato le seguenti classi: 

1) **Comando**: la classe Comando è una classe di tipo Entity e rappresenta caratteristiche e comportamenti che può assumere un comando. Di conseguenza, la responsabilità di questa classe è quella di gestire i comandi inseriti sia dall’utente di tipo giocatore che dall’utente di tipo paroliere. 

2) **Utente**: la classe Utente è una classe di tipo Entity e rappresenta caratteristiche e comportamenti che può assumere un utente generale. La responsabilità di questa classe è quella di gestire l’utente generico e fa da classe padre alle seguenti classi: 

    - **Giocatore**: la classe Giocatore è una classe di tipo Entity e rappresenta caratteristiche e comportamenti che può assumere un utente di tipo giocatore.  
    La responsabilità di questa classe è quella di gestire il giocatore durante tutta la durata della partita. 
    - **Paroliere**: la classe Paroliere è una classe di tipo Entity e rappresenta caratteristiche e comportamenti che può assumere un utente di tipo paroliere.  
    La responsabilità di questa classe è quella di gestire il paroliere durante tutta la durata della partita. 

3) **Controllo**: la classe controllo è una classe di tipo Control e ha la responsabilità di effettuare dei controlli sulle parole che vengono inserite dall’utente di tipo paroliere e dall’utente di tipo giocatore. 

Diagramma delle classi dal punto di vista software:

![concettuale](./img/strutturale.jpg)

RF1:

![concettuale](./img/RF1.jpg)

RF3:

![concettuale](./img/RF3.jpg)

RF6:

![concettuale](./img/RF6.jpg)

Come notato dai diagrammi precedentemente presentati, il progetto è stato realizzato seguendo i principi generali della progettazione Object-Oriented.
1. **Information Hiding e basso accoppiamento**:  
Per le classi da noi rappresentate nel progetto, tutti gli attributi risultano in visibilità "*private*" e per garantire il loro incapsulamento, sono state creati dei metodi getter e setter *publici*. Inoltre, abbiamo suddiviso il nostro sistema in due *package* per garantire al meglio le importazioni dei moduli necessari per l'esecuzione del progetto. Questi pacchetti sono:  
    * *entity*: contiene tutte le classi del modello di dominio.
    * *control*: contiene la classe Controllo per gestire il gioco.  
  
2. **Alta Coesione**:
Per garantire un'alta coesione di ogni componente all'interno del sistema, abbiamo definito in modo univoco le responsabilità di ogni classe dal modello di dominio individuato, in modo tale da garantire modularità e alta dipendenza tra le classi.
3. **Presentazione separata**: 
La realizzazione dell'interfaccia grafica è stata fatta in riga di comando ed è totalmente indipendente dai package *entity* e *control*. Tale scelta è stata presa per poter scrivere i casi di test attraverso le asserzioni testuali. 
4. **DRY**: Ogni parte significativa del classi coinvolte nel progetto sono state implementate in modo autonomo senza dover essere ricopiate in altri punti del sorgente.
5. **Principi SOLID**:
    *  **Single Responsibility Principle**:
        * Ogni classe creata ha una singola responsabilità all'interno del nostro progetto.
    *  **Open/Closed Principle**:
        * Le classi create possono essere estese o chiuse secondo le necessità.
    *  **Liskov Substitution Principle**:
        * Le classi *Giocatore* e *Paroliere* vengono estese dalla classe *Utente* e possono essere utilizzate come *Utente* anche da altre classi.
    * **Interface Segregation Principle**:
        * Non sono presenti pattern progettuali che utilizzano le interfacce.
    * **Dependency Inversion Principle**:
        * Tale principio viene rispsettato, in quanto la classe *Utente* non dipende dalle sue sottoclassi, ossia *Giocatore* e *Paroliere*, ma il viceversa.


# 6. Riepilogo casi di test

Sono stati effettuati i test sulle classi:  

   1. **Controllo**: in particolare sono stati testati i metodi:  
        *  **controlloParola**: in questo caso si è testato il comportamento del Software con l'inserimento di parole non valide (parole troppo lunghe, parole troppo lunghe o parola nulla) e parole valide.

        *  **controllaParola**: in questo caso si è testato il comportamento del software quando vengono inserite parole contenenti numeri o caratteri speciali.

        *  **controlloLettera**: in questo caso si è testato il comportamento del software per verificare se una lettera all'interno della parola inserita dal giocatore è presente o meno all'interno della parola inserita dal paroliere. 

   2. **Comando**: in particolare è stato testato il seguente metodo:
        *  **controlloComando**: in questo caso si è testato il comportamento del software durante l'inserimento di un comando erratto, di un comando giusto o il tentativo per indovinare la parola.

In tutti i casi i test sono andati a buon fine. 

![Tabella](./img/Tabella_coveralls.jpg)

# 7. Manuale utente

Questa guida è rivolta a tutti coloro che vogliono cimentarsi nel nostro gioco, ispirato a **WORDLE**. In seguito verranno descritti i comandi necessari per interagire con il gioco.  

   1. **/GIOCA**: Con questo comando l'utente avrà la possibilità di avviare una nuova partita. Verrà visualizzata la matrice dei tentativi vuota. A questo punto il gioco si prepara a ricevere il tentativo oppure un nuovo comando. 
   2. **/NUOVA <_PAROLA_>**: Con questo comando il paroliere potrà inserire la nuova parola che l'utente dovrà indovinare. 
   3. **<_PAROLA_>**: Questo comando serve all'utente per tentare di indovinare la parola segreta impostata dal paroliere. La parola inserita dovrà contenere solo lettere e deve essere composta da 5 caratteri, altrimenti verrà visualizzato un messaggio di errore. 
   4. **/MOSTRA**: Con questo comando è possibile visualizzare la parola segreta inserita dal paroliere.
   5. **/ABBANDONA**:Con questo comando, previa conferma, l'utente avrà la possibilità di abbandonare la partita corrente. 
   6. **/ESCI**: Con questo comando avviene la chiusura del gioco. 

# 8. Processo di sviluppo e organizzazione del lavoro

Lo sviluppo del progetto è avvenuto seguendo i principi dello sviluppo agile. Per ogni sprint, e per tutta la sua durata ,si sono effettuati degli incontri giornalieri dalle 15.00 alle 19.00 sia in presenza e sia in modalità online tramite la piattaforma Teams. Per lavorare in modalità condivisa abbiamo utilizzato **Github**, per lo sviluppo del codice **Visual Studio Code** e come linguaggio di programmazione **Java**. 

# 9. Analisi retrospettiva 
Quì di seguito viene mostrata la tabella relativa all'analisi retrospettiva.


![Tabella](./img/Whiteboard.jpg)