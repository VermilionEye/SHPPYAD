package ru.tsarev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tsarev.entities.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
