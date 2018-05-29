package com.mp.privatewallet.wallet.collections;

import java.util.List;
import java.util.Optional;

public interface WalletService {

    public void create(final Wallet wallet);
    public void update(final Wallet wallet);
    public void delete(final Wallet wallet);
    public void deleteAll();
    public Optional<Wallet> find(final Wallet wallet);
    public List<Wallet> findByOwnerName(final String ownerName);

}
