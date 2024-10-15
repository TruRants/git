package com.stolle.portal.web;

import org.springframework.web.bind.annotation.RestController;
import com.stolle.portal.domain.Machine;
import com.stolle.portal.domain.MachineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class MachineController {

    @Autowired
    private MachineRepository repository;//create a machine repository object

    //Create a method to get machines
    @RequestMapping("/machines")//By default, @RequestMapping handles all the HTTP method (GET, PUT, POST, and so on) requests.
    public Iterable<Machine> getMachines(){

        return repository.findAll();

    }

}
