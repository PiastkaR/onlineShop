package com.queue.your.patient.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;

import static java.lang.Math.max;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

public class PagedResource {

    public static HttpHeaders toPageResource(Page<?> page, String baseUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", "" + Long.toString(page.getTotalElements()));
        String link = "";
        if (hasNext(page)) {
            link = link(baseUrl, page.getNumber() + 1, page.getSize(), "next") + ",";
        }
        if (hasPrev(page)) {
            link = link(baseUrl, page.getNumber() - 1, page.getSize(), "prev") + ",";
        }

        link += link(baseUrl, max(0, page.getTotalPages() - 1), page.getSize(), "last") + ",";
        link += link(baseUrl, 0, page.getSize(), "first");
        headers.add(HttpHeaders.LINK, link);
        return headers;
    }

    private static boolean hasNext(Page<?> page) {
        return (page.getNumber() + 1) < page.getTotalPages();
    }

    private static boolean hasPrev(Page<?> page) {
        return page.getNumber() > 0;
    }

    private static String link(String url, int page, int size, String navigation) {
        return "<" + compose(url, page, size) + ">; rel=\"" + navigation + "\"";
    }

    private static  String compose(String url, int page, int size) {
        return fromUriString(url).queryParam("page", page).queryParam("size", size).toUriString();
    }
}
