package com.urlshortener;

import com.urlshortener.utils.Utils;

public class UrlShortenerController {
    public static void main(String[] args) {
        Utils utils = new Utils();
        System.out.println("shortUrl = " + utils.createUniqueId(123456L));
        System.out.println("id = " + utils.getUniqueIdFromString(utils.createUniqueId(123456L)));
    }
}
