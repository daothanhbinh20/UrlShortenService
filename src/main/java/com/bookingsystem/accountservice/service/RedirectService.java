package com.bookingsystem.accountservice.service;

import com.bookingsystem.accountservice.repository.RedirectRepository;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Component
public class RedirectService {
    private static final String HASHING_ALGORITHM = "SHA-256";
    private static final Base64.Encoder URL_SAFE_ENCODER = Base64.getUrlEncoder().withoutPadding();
    private final RedirectRepository redirectRepository;

    public RedirectService(final RedirectRepository redirectRepository) {
        this.redirectRepository = redirectRepository;
    }

    public String getLongUrl(final String shortKey) {
        return redirectRepository.getRedirectMapping(shortKey).getLongUrl();
    }

    public String createRedirectMapping(final String longUrl) {
        final String urlShortKey = generateUrlShortKey(longUrl);
        redirectRepository.createRedirectMapping(longUrl, urlShortKey);

        return urlShortKey;
    }

    public String generateUrlShortKey(final String longUrl) {
        try {
            // Generate a SHA-256 hash of the long URL.
            MessageDigest md = MessageDigest.getInstance(HASHING_ALGORITHM);
            byte[] hashBytes = md.digest(longUrl.getBytes());

            // Encode the hash value using URL-safe base64 encoding.
            String shortKey = URL_SAFE_ENCODER.encodeToString(hashBytes);

            return shortKey;
        } catch (NoSuchAlgorithmException exception) {
            throw new RuntimeException("Unable to find hashing algorithm " + HASHING_ALGORITHM, exception);
        }
    }
}
