package orderapp.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import orderapp.account.repository.AccountRepository;

import orderapp.model.Account;

@Service
@Transactional
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> findAccountById(Long accountId) {
        return Optional.ofNullable(accountRepository.findById(accountId))
            .orElseThrow(() -> new AccountNotFoundException("Account not found with ID: " + accountId));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Account createAccount(Account account) {
        final Account newAccount = new Account();
        newAccount.setName(account.getName());
        newAccount.setType(account.getType());
        return accountRepository.save(newAccount);
    }

}
