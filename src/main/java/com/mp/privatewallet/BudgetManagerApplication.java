package com.mp.privatewallet;

import com.mp.privatewallet.account.entity.Account;
import com.mp.privatewallet.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BudgetManagerApplication implements CommandLineRunner {

	@Autowired
	private AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(BudgetManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createInitialData();
	}

	private void createInitialData() {
		accountRepository.save(new Account("Mietek"));
		accountRepository.save(new Account("Zdzisiek"));
		accountRepository.save(new Account("Zenek"));
		accountRepository.save(new Account("Włodek"));
		accountRepository.save(new Account("Jerzy"));
		accountRepository.save(new Account("Bogdan"));

	}
}
