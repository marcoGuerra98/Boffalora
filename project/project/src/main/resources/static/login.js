/**
 * Legge il valore del cookie XSRF-TOKEN impostato da Spring Security.
 */
function getCsrfToken() {
  const match = document.cookie.match(/(?:^|;\s*)XSRF-TOKEN=([^;]*)/);
  return match ? decodeURIComponent(match[1]) : null;
}

document.addEventListener('DOMContentLoaded', () => {
  const toggleBtn = document.querySelector('.toggle-pw');
  const passwordInput = document.querySelector('#password');

  if (toggleBtn && passwordInput) {
    toggleBtn.addEventListener('click', () => {
      const isHidden = passwordInput.type === 'password';
      passwordInput.type = isHidden ? 'text' : 'password';

      const svg = toggleBtn.querySelector('svg');
      if (svg) {
        svg.style.opacity = isHidden ? '1' : '0.4';
      }
      toggleBtn.setAttribute('aria-pressed', String(isHidden));
    });
  }

  const fields = document.querySelectorAll('.field');
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

  const form = document.querySelector('.login-form');
  const submitBtn = document.querySelector('.submit-btn');
  const btnText = submitBtn ? submitBtn.querySelector('.btn-text') : null;
  const errorBox = document.querySelector('#login-error');

  if (form && submitBtn) {
    form.addEventListener('submit', async (event) => {
      event.preventDefault();

      const username = document.querySelector('#username').value;
      const password = document.querySelector('#password').value;

      submitBtn.style.opacity = '0.6';
      submitBtn.style.pointerEvents = 'none';
      if (btnText) {
        btnText.textContent = 'Accesso...';
      }

      if (errorBox) {
        errorBox.classList.add('hidden');
      }

      try {
        const response = await fetch('/api/auth/login', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          credentials: 'include',
          body: JSON.stringify({ username, password })
        });

        if (!response.ok) {
          throw new Error('Credenziali non valide');
        }

        const data = await response.json();
        if (data && data.token) {
          localStorage.setItem('access_token', data.token);
        }

        window.location.href = '/torneo';
      } catch (error) {
        if (errorBox) {
          errorBox.classList.remove('hidden');
        }
      } finally {
        submitBtn.style.opacity = '1';
        submitBtn.style.pointerEvents = 'auto';
        if (btnText) {
          btnText.textContent = 'Entra';
        }
      }
    });
  }

  const firstInput = document.querySelector('.field-input');
  if (firstInput) {
    setTimeout(() => firstInput.focus(), 400);
  }
});

