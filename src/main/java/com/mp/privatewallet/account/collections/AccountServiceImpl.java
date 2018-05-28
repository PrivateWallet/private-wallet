package com.mp.privatewallet.account.collections;

import com.mp.privatewallet.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void create(Account account) {
        Account a = accountRepository.insert(account);
        System.out.println("Account Created: " + a);
    }

    @Override
    public void update(Account account) {
        Account a = accountRepository.save(account);
        System.out.println("Account Updated: " + a);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
        System.out.println("Account Deleted: " + account.getId());
    }

    @Override
    public void deleteAll() {
        accountRepository.deleteAll();
    }

    @Override
    public Optional<Account> find(Account account) {
        return accountRepository.findById(account.getId());
    }

    @Override
    public Optional<Account> findbyId(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<Account> findByOwnerName(String ownerName) {
        return accountRepository.findByOwnerName(ownerName);
    }
}
