Project: Minerva

======================================================================================

For å kjøre dette prosjektet må følgende ting settes opp/endres:

1. En tom database ved navn "minerva" må eksistere på systemet (localhost).

2. hibernate.cfg.xml som ligger i src-mappen må endres til følgende:
	a) attributten "connection.password" må bli endret til ditt MySQL passord
	b) hvis "root" ikke er standard brukernavn for MySQL, endre dette i attributten "connection.username"
	c) hvis du har lagt en tom database med annet navn enn "minerva", endre verdien i attributten
	   "connection.url" til "jdbc:mysql://localhost:3306/" + DatabaseNavn
	   
3. Kjør CreateTables.java i src/Connection

4. Kjør så CreateInserts.java i samme pakke (src/Connection)

Hvis du opplever problemer med å laste opp bilde til profilen, gå inn på UploadImageServlet.java i
src/servlet, gå til linje 70, avkommenter denne og neste linje og kommenter koden på linje 75.

NB! Dette har blitt utviklet ved bruk av Tomcat Server. Vedlagt ligger en PDF for oppsett av Tomcat for å få dette til å kjøre.


