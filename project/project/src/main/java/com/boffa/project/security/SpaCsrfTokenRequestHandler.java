package com.boffa.project.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.csrf.CsrfTokenRequestHandler;
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;
import org.springframework.util.StringUtils;

import java.util.function.Supplier;

/**
 * Handler CSRF pensato per Single-Page Application.
 * <p>
 * Delega al {@link XorCsrfTokenRequestAttributeHandler} per la risoluzione
 * del valore ricevuto nel body/parametro (doppia codifica XOR), ma se il
 * token arriva come header (tipico di fetch JS) lo confronta in chiaro
 * tramite il {@link CsrfTokenRequestAttributeHandler} base.
 */
public final class SpaCsrfTokenRequestHandler extends CsrfTokenRequestAttributeHandler {

    private final CsrfTokenRequestHandler delegate = new XorCsrfTokenRequestAttributeHandler();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       Supplier<CsrfToken> csrfToken) {
        // Rende il token disponibile come attributo della request
        this.delegate.handle(request, response, csrfToken);
    }

    @Override
    public String resolveCsrfTokenValue(HttpServletRequest request, CsrfToken csrfToken) {
        // Se il valore arriva dall'header (X-XSRF-TOKEN) → confronto in chiaro
        if (StringUtils.hasText(request.getHeader(csrfToken.getHeaderName()))) {
            return super.resolveCsrfTokenValue(request, csrfToken);
        }
        // Altrimenti (body/parametro) → decodifica XOR
        return this.delegate.resolveCsrfTokenValue(request, csrfToken);
    }
}

