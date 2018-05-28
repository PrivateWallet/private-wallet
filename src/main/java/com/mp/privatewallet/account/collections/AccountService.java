package com.mp.privatewallet.account.collections;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public void create(final Account account);
    public void update(final Account account);
    public void delete(final Account account);
    public void deleteAll();
    public Optional<Account> find(final Account account);
    public Optional<Account> findbyId(final String Id);
    public Optional<Account> findByOwnerName(final String ownerName);
}
