package com.poly.service;

<<<<<<< HEAD
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

=======
import com.poly.entity.Account;

public interface AccountService {
	
	Account findById(String username);
}
>>>>>>> f116c7ac0dab46974b91c399d8283f0e5908798e
