package com.abhishekjha.urlshortner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class services {
    @Autowired
    urlrepository urlrepository;
    String baseUrl = "localhost:8080/";

    public ResponseEntity<String> getLink(String shortUrl) {
        if (urlrepository.existsByshortUrl(shortUrl))
            return new ResponseEntity<>(urlrepository.findByshortUrl(shortUrl).getLongUrl(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Link not found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> setLink(url url) {
        if(urlrepository.existsById(url.getLongUrl()))
            return new ResponseEntity<>("Already Exist\n"+baseUrl+urlrepository.findById(url.getLongUrl()).get().getShortUrl(),HttpStatus.ALREADY_REPORTED);
        
        String hash = hashgenerator.getHashString();
        while (urlrepository.existsByshortUrl(url.shortUrl)) {
            hash = hashgenerator.getHashString();
        }
        String shortUrl = baseUrl + hash;
        url.setShortUrl(hash);
        urlrepository.save(url);
        return new ResponseEntity<>(shortUrl,HttpStatus.OK);
    }
}
