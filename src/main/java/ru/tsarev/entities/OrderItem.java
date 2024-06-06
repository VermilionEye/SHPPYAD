package ru.tsarev.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    //@JoinColumn(name = "offers_id")
    private Offer book;
    private int amount;
    @ManyToOne
    private Order order;
}
