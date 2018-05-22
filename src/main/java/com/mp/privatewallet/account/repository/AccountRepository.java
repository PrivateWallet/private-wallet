package com.mp.privatewallet.account.repository;

import com.mp.privatewallet.account.collections.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

//@RepositoryRestResource(exported = false)
public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findByOwnerName(String name);
}
