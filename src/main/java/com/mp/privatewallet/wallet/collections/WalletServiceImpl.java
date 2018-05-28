package com.mp.privatewallet.wallet.collections;

import com.mp.privatewallet.wallet.collections.WalletService;
import com.mp.privatewallet.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mp.privatewallet.wallet.collections.Wallet;

import java.util.List;
import java.util.Optional;

@Service("walletService")
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepo;

    @Override
    public void create(final Wallet wallet) {
        Wallet w = walletRepo.insert(wallet);
        System.out.println("Wallet Created: " + w);
    }

    @Override
    public void update(final Wallet wallet) {
        Wallet w = walletRepo.save(wallet);
        System.out.println("Wallet Updated: " + w);
    }

    @Override
    public void delete(final Wallet wallet) {
        walletRepo.delete(wallet);
        System.out.println("Wallet Deleted: " + wallet.getId());

    }

    @Override
    public void deleteAll() {
        walletRepo.deleteAll();
    }

    @Override
    public Optional<Wallet> find(final Wallet wallet) {
        return walletRepo.findById(wallet.getId());
    }

    @Override
    public List<Wallet> findByOwnerName(final String ownerName) {

        return walletRepo.findByOwnerNameQuery(ownerName);
    }
}
