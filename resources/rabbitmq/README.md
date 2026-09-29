Aggiunto restart: always: Fondamentale per far sì che RabbitMQ riparta da solo se il server si riavvia.

Aggiunti i volumes: Senza questi, se elimini il container per aggiornarlo, perderesti tutte le code, i messaggi e gli utenti creati. Con i volumi, i dati restano persistenti sul tuo disco.
