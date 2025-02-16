document.getElementById("mioBottone").addEventListener('click', () => {
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
    .then(response => response.json())
    .then(anagrafica => {
        console.log('Success:', anagrafica);
        alert('Dati inviati con successo!');
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Si è verificato un errore durante l\'invio dei dati.');
    });
});