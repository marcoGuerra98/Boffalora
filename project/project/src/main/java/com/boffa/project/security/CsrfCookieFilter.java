package com.boffa.project.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filtro che forza il caricamento (lazy → eager) del {@link CsrfToken}
 * ad ogni richiesta, in modo che Spring Security scriva il cookie
 * {@code XSRF-TOKEN} anche per le richieste GET (necessario per le SPA
 * che devono leggere il cookie prima di effettuare un POST).
 */
public final class CsrfCookieFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        if (csrfToken != null) {
            // Forza la generazione/scrittura del cookie
            csrfToken.getToken();
        }
        filterChain.doFilter(request, response);
    }
}

