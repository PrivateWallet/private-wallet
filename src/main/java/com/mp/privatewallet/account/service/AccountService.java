package com.mp.privatewallet.account.service;

import com.mp.privatewallet.account.collections.Account;
import com.mp.privatewallet.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements AccountSearch{

    @Autowired
    private AccountRepository accountRepository;


    public Account findAccountByOwnerName(String name) {
        final Optional<Account> optionalAccount = accountRepository.findByOwnerName(name);
        if(!optionalAccount.isPresent()) {
            try {
                throw new Exception("No account found for name: ");
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return optionalAccount.get();
    }

}
