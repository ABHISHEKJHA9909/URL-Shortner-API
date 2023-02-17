package com.abhishekjha.urlshortner;

import org.springframework.data.repository.CrudRepository;

public interface urlrepository extends CrudRepository<url,String>{

    boolean existsByshortUrl(String shortUrl);

    url findByshortUrl(String shortUrl);
    
}
