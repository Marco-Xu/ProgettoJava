# ProjectOOP
Progetto per l'esame di Programmazione ad Oggetti, Università Politecnica delle Marche, Anno 2020/2021.

Sviluppato dagli studenti Marco Xu e Davide Balducci.
## Introduzione
Il seguente progetto implementa un servizio meteo che, data una città, permette di visualizzare tutte le informazioni attuali relative alla temperatura e alle condizioni meteo.

Il servizio salva le informazioni ogni ora e dà la possibilità di impostare il sistema di misura in gradi Celsius, Kelvin o Fahrenheit.

Tale progetto inoltre genera statistiche periodiche riguardanti valori minimi, massimi e media di temperature reali e percepite con filtraggio di tali  statistiche in base alla periodicità su un range personalizzabile (inserendo il numero di giorni richiesti).
## Come si usa?
Tramite l'ambiente di sviluppo Eclipse si possono eseguire le seguenti operazioni:
1. Clonare la repository da GitHub;
2. Eseguire il codice come SpringBoot application;
3. Utilizzare un API testing come ad esempio Postman.

In seguito all'avvenuto successo di questi tre passi è possibile utilizzare il servizio meteo sulla porta http://localhost:8081.
### Richieste
| Tipo | Rotta |                        Funzione                                   |
|------|-------|-------------------------------------------------------------------|
| GET  |/metadata|Restituisce gli alias utilizzati.                                |
| GET  |/weather?city="city"|Restituisce le condizioni meteo della "city" inserita.|
| GET  |/weather?city="city"&unit="type"|Restituisce le condizioni meteo della "city" inserita con l'unità di misura "type" richiesta.|
| GET  |/save?city="city"|Salva i dati meteo della "city" inserita nella cartella 'data'.|
| GET  |/check?city="city"|Visualizza a schermo tutti i dati precedentemente salvati della "city" inserita.|
| POST |/stats?city="city"&period="period"|Restituisce le statistiche della "city" inserita (se presente uno storico di essa) con periodicità "period" personalizzabile.|
| POST |/stats?city="city"&period="period"&unit="type"|Restituisce le statistiche della "city" inserita (se presente uno storico di essa) con periodicità "period" personalizzabile con unità di misura "type" richiesta.|

### Note
Il parametro "type" per la selezione dell'unità di misura accetta i seguenti formati:
* Per i gradi Celsius: "Celsius", "celsius", "C", "c";
* Per i gradi Kelvin: "Kelvin", "kelvin", "K", "k";
* Per i gradi Fahrenheit: "Fahrenheit", "fahrenheit", "F", "f".

Il parametro "period" accetta solo i giorni in numero intero (es. una settimana = 7, un mese = 30, ecc...).
## Diagrammi UML
### Diagramma dei casi d'uso
![Diagramma casi d'uso.PNG](https://github.com/Marco-Xu/ProgettoJava/UML)
