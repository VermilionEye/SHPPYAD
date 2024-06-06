package ru.tsarev.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.tsarev.entities.Offer;
import ru.tsarev.repositories.OfferRepository;

@Service
@AllArgsConstructor
@Slf4j
public class OfferService {
    private OfferRepository toyRepository;

    public Iterable<Offer> findAll() {
        return toyRepository.findAll();
    }
}
