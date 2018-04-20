package orderapp.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import orderapp.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
