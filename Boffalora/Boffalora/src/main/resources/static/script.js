document.getElementById('dataForm').addEventListener('submit', function(event) {
    event.preventDefault();

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
        cap: document.getElementById('cap')
    };

    const user = {
        anagrafica: anagrafica,
        email: document.getElementById('email').value,
        numeroCellulare: document.getElementById('numeroCellulare').value,
        statoIscrizione: document.getElementById('statoIscrizione').value
    }

    fetch('/addListToDB', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
    .then(response => response.json())
    .then(user => {
        console.log('Success:', user);
        alert('Dati inviati con successo!');
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Si è verificato un errore durante l\'invio dei dati.');
    });
});