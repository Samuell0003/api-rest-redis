package com.iftm.apirestredis.services;

import com.iftm.apirestredis.model.Immobile;
import com.iftm.apirestredis.repositories.ImmobileRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImmobileService {
    @Autowired
    private ImmobileRepository immobileRepository;
    @Cacheable(cacheNames = "all-immobile")
    public List<Immobile> findAll() {
        return immobileRepository.findAll();
    }

    @Cacheable(cacheNames = "single-immobile", key = "#id")
    public Immobile findById(ObjectId id) {
        return immobileRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = {"all-immobile", "single-immobile"}, allEntries = true)
    public Immobile save(Immobile immobile) {
        return immobileRepository.save(immobile);
    }

    @CacheEvict(value = {"all-immobile", "single-immobile"}, allEntries = true)
    public Immobile update(Immobile immobile) {
        var immobileDb = immobileRepository.findById(immobile.getId()).orElseThrow();

        immobileDb.setAddress(immobile.getAddress());
        immobileDb.setArea(immobile.getArea());
        immobileDb.setValue(immobile.getValue());

        return immobileRepository.save(immobileDb);
    }

    @CacheEvict(value = {"all-immobile", "single-immobile"}, allEntries = true)
    public String delete(ObjectId objectId) {
        immobileRepository.findById(objectId).orElseThrow();

        immobileRepository.deleteById(objectId);

        return "Imovel deletado com sucesso";
    }
}
