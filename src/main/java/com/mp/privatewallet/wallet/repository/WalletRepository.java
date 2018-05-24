package com.mp.privatewallet.wallet.repository;

import com.mp.privatewallet.wallet.collections.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository extends MongoRepository<Wallet, String> {

}
