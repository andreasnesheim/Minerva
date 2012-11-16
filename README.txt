Project: Minerva

======================================================================================

For � kj�re dette prosjektet m� f�lgende ting settes opp/endres:

1. En tom database ved navn "minerva" m� eksistere p� systemet (localhost).

2. hibernate.cfg.xml som ligger i src-mappen m� endres til f�lgende:
	a) attributten "connection.password" m� bli endret til ditt MySQL passord
	b) hvis "root" ikke er standard brukernavn for MySQL, endre dette i attributten "connection.username"
	c) hvis du har lagt en tom database med annet navn enn "minerva", endre verdien i attributten
	   "connection.url" til "jdbc:mysql://localhost:3306/" + DatabaseNavn
	   
3. Kj�r CreateTables.java i src/Connection

4. Kj�r s� CreateInserts.java i samme pakke (src/Connection)

Hvis du opplever problemer med � laste opp bilde til profilen, g� inn p� UploadImageServlet.java i
src/servlet, g� til linje 70, avkommenter denne og neste linje og kommenter koden p� linje 75.

NB! Dette har blitt utviklet ved bruk av Tomcat Server. Vedlagt ligger en PDF for oppsett av Tomcat for � f� dette til � kj�re.


