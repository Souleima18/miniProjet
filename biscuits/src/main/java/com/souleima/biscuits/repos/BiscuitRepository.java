package com.souleima.biscuits.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.souleima.biscuits.entities.Biscuit;
public interface BiscuitRepository extends JpaRepository<Biscuit, Long> {

}
