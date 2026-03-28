package com.boffa.project.dto.auth;

public record LoginResponse(String token, String tokenType, long expiresInMs) {
}

