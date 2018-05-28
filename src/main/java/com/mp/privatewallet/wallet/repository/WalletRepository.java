package com.mp.privatewallet.wallet.repository;

import com.mp.privatewallet.wallet.collections.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends MongoRepository<Wallet, String> {

    @Query("{ 'ownerName' : ?0 }")
    List<Wallet> findByOwnerNameQuery(final String ownerName);



}
