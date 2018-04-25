package orderapp.account.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import orderapp.model.Account;

@RestController
@RequestMapping("/accounts")
public class AccountServiceController {
	
	@Autowired
	AccountService accountService;
	   
    @GetMapping("/{accountId}")
	public Optional<Account> getAccount(@PathVariable Long accountId) {	
		System.out.println("Getting account with id: " + accountId);
		return accountService.findAccountById(accountId);	
	}
	
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        System.out.println("Creating account: " + account);
        return accountService.createAccount(account);
    }
 
}
