# Bot_Discord

Pentru acest proiect au fost folosite ROME pentru preluarea de date din RSS si JDA pentru conectarea la API-ul discord-ului.



Fiecare user care vorbeste cu bot-ul este retinut in clasa User.java pentru a stabili starea in care a ramas.

Comenzile bot-ului sunt stabilite in clasa Commands.java care in final preia intrebarile utilizand clasa ServerRSS.java ce implementeaza libraria ROME.

Intrebarile sunt salvate in cate un fisier xml separat pentru fiecare limbaj de programare.



In clasa Main.java ne conectam la API folosind cheia privata oferita de discord dupa care initiem un listener pentru a astepta mesaje noi de la user.



Bujor Bogdan a creat clasa User si a implementat functionalitatea de a schimba intrebarile.

Bucataru Cristian a creat Bot-ul, Canalul de discord si Set-up-ul initial pentru a conecta JDA la API.

Restul proiectului a fost facut impreuna discutand pe Discord pentru a ne documenta amandoi despre folosirea librariilor.
