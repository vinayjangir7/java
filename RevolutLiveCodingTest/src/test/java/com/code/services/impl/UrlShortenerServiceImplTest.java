package com.code.services.impl;

import com.code.exceptions.InvalidSeoKeywordException;
import com.code.exceptions.InvalidUrlException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlShortenerServiceImplTest {

    String inputUrl = "http://longUrl.com/abstract";
    String seoKeyword = "code";
    UrlShortenerServiceImpl service = new UrlShortenerServiceImpl();

    @Test
    @DisplayName("")
    void getShortenUrlTestForInvalidSEO() {
        assertThrows(InvalidSeoKeywordException.class, () -> service.shortenUrl(inputUrl, null));
    }

    @Test
    @DisplayName("")
    void getShortenUrlTestForLength() throws InvalidSeoKeywordException, InvalidUrlException {
        String shortUrl = service.shortenUrl(inputUrl, seoKeyword);
        assertTrue(inputUrl.length() > shortUrl.length());
    }

    @Test
    @DisplayName("")
    void getShortenUrlTestForCorrectResult() throws InvalidSeoKeywordException, InvalidUrlException {
        String shortUrl = service.shortenUrl(inputUrl, seoKeyword);
        assertTrue(shortUrl.contains(seoKeyword));
    }
}