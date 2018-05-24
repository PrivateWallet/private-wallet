package com.mp.privatewallet.account.service;

import com.mp.privatewallet.account.collections.Account;

public interface AccountSearch {
    Account findAccountByOwnerName(String name);
}
