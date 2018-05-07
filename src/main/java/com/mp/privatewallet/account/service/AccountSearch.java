package com.mp.privatewallet.account.service;

import com.mp.privatewallet.account.entity.Account;

public interface AccountSearch {
    Account findAccountByOwnerName(String name);
}
