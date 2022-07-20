package com.code.services.impl;

import com.code.AppConstants;
import com.code.exceptions.InvalidSeoKeywordException;
import com.code.exceptions.InvalidUrlException;
import com.code.services.UrlShortenerService;

import java.util.Optional;

/*
  Input:
    URL: http://looooong.com/somepath
    SEO keyword: MY-NEW-WS
  Output:
    URL: http://short.com/MY-NEW-WS

  Input:
    URL: http://looooong.com/somepath
    SEO keyword: POTATO
  Output:
    URL: http://short.com/POTATO
* */

public class UrlShortenerServiceImpl implements UrlShortenerService {

    @Override
    public String shortenUrl(String inputUrl, String SEOKeyword) throws InvalidSeoKeywordException, InvalidUrlException {
        StringBuilder shortUrl = new StringBuilder();
        Optional<String> urlOptional = Optional.ofNullable(inputUrl);
        Optional<String> seoKeywordOptional = Optional.ofNullable(SEOKeyword);
        if (urlOptional.isPresent() && isUrlValid(urlOptional.get())) {
            if (seoKeywordOptional.isPresent()) {
                shortUrl.append(AppConstants.SHORT_URL_PREFIX).append(SEOKeyword);
                return shortUrl.toString();
            } else {
                throw new InvalidSeoKeywordException("Seo keyword is invalid");
            }
        } else {
            throw new InvalidUrlException("Input url is invalid");
        }
    }

    private boolean isUrlValid(String url) {
        /*Some regex check for url validity*/
        return true;
    }
}
