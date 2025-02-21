document.getElementById("copy-button").addEventListener('click', () => {
    event.preventDefault();

    const iban = document.getElementById('iban').value;

    // Copia il testo negli appunti
    navigator.clipboard.writeText(iban)
      .then(() => {
        // Mostra un messaggio di conferma (opzionale)
        console.log("Testo copiato negli appunti!");
      })
      .catch(err => {
        // Gestisci eventuali errori
        console.error("Errore durante la copia: ", err);
      });

});