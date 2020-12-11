package com.hmaida.chaussures.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmaida.chaussures.entities.Chaussures;

public interface ChaussuresRepository extends JpaRepository<Chaussures, Long> {

}
