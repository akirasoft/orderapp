package orderapp.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import orderapp.model.Account;

@RestController
public class AccountServiceController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccount(@PathVariable("id") String id) {	
		System.out.println("Getting account with id: " + id);
		Account account = accountService.getAccount(Integer.parseInt(id));
		if (account == null) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Account>(account, HttpStatus.OK);		
	}
	
    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public ResponseEntity<Void> createAccount(@RequestBody Account account, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating account: " + account);
        int id = accountService.createAccount(account);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/accounts/{id}").buildAndExpand(id).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
}
