# ProjectOOP
Progetto per l'esame di Programmazione ad Oggetti, Università Politecnica delle Marche, Anno 2020/2021.

Sviluppato dagli studenti Marco Xu e Davide Balducci.
## Introduzione
Il seguente progetto implementa un servizio meteo che, data una città, permette di visualizzare tutte le informazioni attuali relative alla temperatura e alle condizioni meteo.

Il servizio salva le informazioni ogni ora e dà la possibilità di impostare il sistema di misura in gradi Celsius, Kelvin o Fahrenheit.

Tale progetto inoltre genera statistiche periodiche riguardanti valori minimi, massimi, media e varianza di temperature reali e percepite con filtraggio di tali statistiche in base alla periodicità su un range personalizzabile (inserendo il numero di giorni richiesti).
## Come si usa?
Tramite l'ambiente di sviluppo [Eclipse](https://www.eclipse.org/downloads/) si possono eseguire le seguenti operazioni:
1. Clonare la repository da [GitHub](https://github.com/Marco-Xu/ProgettoJava);
2. Eseguire il codice come SpringBoot application;
3. Utilizzare un API testing come ad esempio [Postman](https://www.postman.com/).

In seguito all'avvenuto successo di questi tre passi è possibile utilizzare il servizio meteo sulla porta http://localhost:8081.
### Richieste
| Tipo | Rotta |                        Funzione                                   |
|------|-------|-------------------------------------------------------------------|
| GET  |/metadata|Restituisce gli alias utilizzati.                                |
| GET  |/weather?city="city"|Restituisce le condizioni meteo della città(city) inserita.|
| GET  |/weather?city="city"&unit="type"|Restituisce le condizioni meteo della città(city) inserita con l'unità di misura(type) richiesta.|
| GET  |/save?city="city"|Salva i dati meteo della città(city) inserita nella cartella del progetto [data](https://github.com/Marco-Xu/ProgettoJava/tree/master/ProjectOOP/ProjectOOP/data).|
| GET  |/check?city="city"|Visualizza a schermo tutti i dati precedentemente salvati della città(city) inserita.|
| POST |/stats?city="city"&period="period"|Restituisce, se presenti, le statistiche della città(city) inserita con periodicità(period) personalizzabile.|
| POST |/stats?city="city"&period="period"&unit="type"|Restituisce, se presenti, le statistiche della città(city) inserita con periodicità(period) personalizzabile e con unità di misura(type) richiesta.|

### Note
Il parametro "type" per la selezione dell'unità di misura accetta i seguenti formati:
* Per i gradi Celsius: "Celsius", "celsius", "C", "c";
* Per i gradi Kelvin: "Kelvin", "kelvin", "K", "k";
* Per i gradi Fahrenheit: "Fahrenheit", "fahrenheit", "F", "f".

Il parametro "period" accetta solo giorni in numero intero (es. una settimana = 7, un mese = 30, ecc...).

La nostra raccolta dati è composta dalle seguenti città:
* Ancona;
* Rimini;
* San Marino.
## Diagrammi UML
### Diagramma dei casi d'uso
![Diagramma casi d'uso](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/Diagramma%20casi%20d'uso.PNG)
### Diagramma delle classi
#### Package Controller
![Diagramma classi Controller](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/Diagramma%20classi%20Controller.PNG)
#### Package Data
![Diagramma classi Data](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/Diagramma%20classi%20Data.PNG)
#### Package Type
![Diagramma classi Type](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/Diagramma%20classi%20Type.PNG)
#### Package Stats
![Diagramma classi Stats](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/Diagramma%20classi%20Stats.PNG)
#### Package OpenWeather
![Diagramma classi OpenWeather](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/Diagramma%20classi%20OpenWeather.PNG)
#### Package Exceptions
![Diagramma classi Exceptions](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/Diagramma%20classi%20Exceptions.PNG)
### Diagramma delle  Sequenze
#### GET /metadata
![metadata](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/metadata.PNG)
#### GET /weather?city="city"
![seq1](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/seq1.PNG)
#### GET /weather?city="city"&unit="type"
![seq2](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/seq2.PNG)
#### GET /save?city="city"
![seq3](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/seq3.PNG)
#### GET /check?city="city"
![seq4](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/seq4.PNG)
#### POST /stats?city="city"&period="period"
![seq5](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/seq5.PNG)
#### POST /stats?city="city"&period="period"&unit="type"
![seq6](https://github.com/Marco-Xu/ProgettoJava/blob/master/UML/seq6.PNG)
