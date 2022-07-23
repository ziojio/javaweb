package com.ziojio.javaweb.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    List<Account> findByLastName(String lastName);

    Account findById(int id);
}
