package com.stolle.portal.domain;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerid;
    private String customerName, location;

    public Customer(){
    }

    public Customer(String customerName, String location){
        super();
        this.customerName = customerName;
        this.location = location;
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Machine> machines;

    public List<Machine> getMachines(){
        return machines;
    }

    public void setMachines(List<Machine> machines){
        this.machines = machines;
    }


    public long getCustomerid(){
        return customerid;
    }

    public void setCustomerid(long customerid){
        this.customerid = customerid;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

}
