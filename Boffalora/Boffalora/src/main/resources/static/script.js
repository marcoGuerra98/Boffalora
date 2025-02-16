document.getElementById("mioBottone").addEventListener('click', () => {
    event.preventDefault();

    // Mostra l'overlay prima di inviare la richiesta
    document.getElementById('loading-overlay').style.display = 'flex';

    const anagrafica = {
        nome: document.getElementById('nome').value,
        cognome: document.getElementById('cognome').value,
        sesso: document.getElementById('sesso').value,
        codiceFiscale: document.getElementById('codiceFiscale').value,
        dataNascita: document.getElementById('dataNascita').value,
        comuneNascita: document.getElementById('comuneNascita').value,
        nazioneNascita: document.getElementById('nazioneNascita').value,
        nazioneResidenza: document.getElementById('nazioneResidenza').value,
        comuneResidenza: document.getElementById('comuneResidenza').value,
        indirizzo: document.getElementById('indirizzo').value,
        cap: document.getElementById('cap').value
    };

    const user = {
        anagrafica: anagrafica,
        email: document.getElementById('email').value,
        numeroCellulare: document.getElementById('numeroCellulare').value
    }

    fetch('/api/anagrafica/setAnagrafica', {
        method: 'POST',
            headers: {
               'Content-Type': 'application/json'
        },
        body: JSON.stringify(anagrafica)
    })
    .then(response => {
         console.log('Risposta del server:', response);
         if (response.ok) {
             return response.json(); // <--- Sposta response.json() qui
         } else {
             alert('Errore durante l\'invio dei dati.');
             window.location.href = '/paginaErrore.html';
             throw new Error('Errore nella richiesta'); // <--- Importante: lancia un errore per evitare l'esecuzione del .then successivo
         }
    })
    .then(anagrafica => { // <--- Questo blocco viene eseguito solo se response.ok è true
        console.log('Success:', anagrafica);
        alert('Dati inviati con successo!');
        window.location.href = '/paginaSuccesso.html'; // <--- Reindirizza qui solo dopo il successo completo
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Si è verificato un errore durante l\'invio dei dati.');
    });
});