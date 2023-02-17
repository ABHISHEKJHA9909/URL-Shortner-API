package com.abhishekjha.urlshortner;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class url {
    @Id
    String longUrl;
    String shortUrl;

    public url() {
    }

    public url(String longUrl, String shortUrl) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return this.longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return this.shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public url longUrl(String longUrl) {
        setLongUrl(longUrl);
        return this;
    }

    public url shortUrl(String shortUrl) {
        setShortUrl(shortUrl);
        return this;
    }
}