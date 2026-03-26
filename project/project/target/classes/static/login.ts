// login.ts — Interazioni pagina di login

document.addEventListener('DOMContentLoaded', () => {

  // ── Toggle visibilità password ──────────────────
  const toggleBtn = document.querySelector<HTMLButtonElement>('.toggle-pw');
  const passwordInput = document.querySelector<HTMLInputElement>('#password');

  if (toggleBtn && passwordInput) {
    toggleBtn.addEventListener('click', () => {
      const isHidden = passwordInput.type === 'password';
      passwordInput.type = isHidden ? 'text' : 'password';

      // Aggiorna l'icona (eye aperto / chiuso)
      const svg = toggleBtn.querySelector('svg');
      if (svg) {
        svg.style.opacity = isHidden ? '1' : '0.4';
      }
      toggleBtn.setAttribute('aria-pressed', String(isHidden));
    });
  }

  // ── Animazione staggerata dei campi ────────────
  const fields = document.querySelectorAll<HTMLElement>('.field');
  fields.forEach((field, i) => {
    field.style.opacity = '0';
    field.style.transform = 'translateY(10px)';
    field.style.transition = `opacity 0.5s ease ${0.15 + i * 0.1}s, transform 0.5s ease ${0.15 + i * 0.1}s`;

    requestAnimationFrame(() => {
      requestAnimationFrame(() => {
        field.style.opacity = '1';
        field.style.transform = 'translateY(0)';
      });
    });
  });

  // ── Animazione pulsante al submit ──────────────
  const form = document.querySelector<HTMLFormElement>('.login-form');
  const submitBtn = document.querySelector<HTMLButtonElement>('.submit-btn');

  if (form && submitBtn) {
    form.addEventListener('submit', () => {
      submitBtn.style.opacity = '0.6';
      submitBtn.style.pointerEvents = 'none';

      const btnText = submitBtn.querySelector<HTMLElement>('.btn-text');
      if (btnText) btnText.textContent = 'Accesso…';
    });
  }

  // ── Focus automatico sul primo campo ───────────
  const firstInput = document.querySelector<HTMLInputElement>('.field-input');
  if (firstInput) {
    setTimeout(() => firstInput.focus(), 400);
  }

});
