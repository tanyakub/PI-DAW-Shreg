package com.proyecto.shreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.shreg.model.Peticion;
//peticion,id

public interface PeticionRepository extends JpaRepository<Peticion, Integer> {

    //habla con mysql

    //con esto se crea:
    /* peticionRepository.save(...)
    peticionRepository.findAll()
    peticionRepository.findById(...)
    peticionRepository.deleteById(...)*/
}