package com.code.services;

import com.code.exceptions.InvalidSeoKeywordException;
import com.code.exceptions.InvalidUrlException;

public interface UrlShortenerService {

    public String shortenUrl(String inputUrl, String SEOKeyword) throws InvalidSeoKeywordException, InvalidUrlException;

}
