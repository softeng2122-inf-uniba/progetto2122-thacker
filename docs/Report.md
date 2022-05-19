# Report
# 1. Introduzione
La seguente relazione tecnica è relativa alla creazione del gioco di parole chiamato Wordle, ispirato all'omonimo gioco presente sul sito The New York Time, pubblicato da Josh Wardle nel 2021. In termini pratici, l'obiettivo del gioco è quello di indovinare una parola nascosta formata da un numero di lettere prestabilito, solitamente cinque, in un numero massimo di tentativi, anch'esso deciso in precedenza (solitamente 6). 
In questo gioco esistono due ruoli fondamentali, ovvero il paroliere e il giocatore. Il paroliere ha il compito di andare ad impostare nel gioco una parola segreta che il giocatore dovrà indovinare mentre il giocatore dovrà appunto cercare di indovinare la parola entro il numero di tentativi stabiliti. Nel gioco originale:
1)  Se una lettera diventa verde vuol dire che abbiamo indovinato la sua posizione nella parola. 
2)  Se è gialla significa che quella lettera è inclusa nella parola ma non nella posizione giusta. 
3) Se è grigia significa che non compare nella parola. 

La realizzazione del gioco è stata suddivisa in 3 sprint diversi. A partire dallo Sprint 0 fino ad arrivare allo Sprint 2. È stato adottato lo sviluppo agile e sono stati seguiti i 12 principi stabiliti dal framework di sviluppo Scrum. Il progetto è stato sviluppato tramite il linguaggio Java con l’aiuto della piattaforma GitHub per la creazione di un repository apposito per il progetto per il corso di Ingegneria del Software.

# 2. Modello di dominio