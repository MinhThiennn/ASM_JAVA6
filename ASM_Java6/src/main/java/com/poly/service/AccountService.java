package com.poly.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDao;
import com.poly.entity.Account;

@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public Optional<Account> getAccountByUsername(String username) {
        return accountDao.findByUsername(username);
    }

    public void updateAccountPassword(Account account, String newPassword) {
        account.setPassword(newPassword);
        accountDao.save(account);
    }
}

