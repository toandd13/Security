package com.example.shopappbe.repositories;

import com.example.shopappbe.entities.Role;
import com.example.shopappbe.entities.RoleEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
    Optional<Role> findByName(RoleEnum name);


}
