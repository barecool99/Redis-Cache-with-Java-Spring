package com.lilium.redis.controller;

import com.lilium.redis.dto.PersonDTO;
import com.lilium.redis.service.RedisValueCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // access point for CACHE data
@RequestMapping("/api/person")
public class PersonController {
    private final RedisValueCache valueCache;

    @Autowired
    public PersonController(final RedisValueCache valueCache) {
        this.valueCache = valueCache;
    }
    @PostMapping // requestbody is DTO we created(fields) so that passes on our endpoint.
    public void cachePerson(@RequestBody final PersonDTO dto){
        valueCache.cache(dto.getId(), dto); //dto.id-key, store in dto.
    }
    //get endpoint to fetch the id
    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable final String id){
        return (PersonDTO) valueCache.getCachedValue(id);
    }
    @DeleteMapping("/{id")
    public void deletePerson(@PathVariable final String id){
        valueCache.deleteCachedValue(id);
    }
}
