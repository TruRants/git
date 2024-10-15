package com.stolle.portal.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*This is an entity class that should be pointing at the primary key of the machine table */

@Entity
public class Machine {

    @Id//primary key in the data base
    @GeneratedValue(strategy = GenerationType.AUTO)//JPA provider selects the best strategy for a particular database and that it is also the default gneration type
    private long id;
    private String brand;

    public Machine(){}

    public Machine(String brand, Customer customer){

        super();
        this.brand = brand;
        this.customer = customer;

    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer")
    private Customer customer;


    //Getter and Setter
    public Customer getCustomer(){
        return customer;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }






}
