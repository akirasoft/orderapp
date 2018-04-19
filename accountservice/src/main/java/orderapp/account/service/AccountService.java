package orderapp.account.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import orderapp.model.Account;

@Service
public class AccountService {
	
	int i = 0;
	
	private Map<Integer, Account> accounts = new HashMap<Integer, Account>();

	public Account getAccount(int id) {
		return accounts.get(id);
	}
	
	public int createAccount(Account account) {
		int id = i++ % 25;
		account.setId(id);
		accounts.put(id, account);
		return id;
	}
}
