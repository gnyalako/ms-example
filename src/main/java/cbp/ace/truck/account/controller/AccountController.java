package cbp.ace.truck.account.controller;

import cbp.ace.truck.account.dto.AccountDto;
import cbp.ace.truck.account.exceptions.DataNotFoundException;
import cbp.ace.truck.account.exceptions.ServerException;
import cbp.ace.truck.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Account Rest Service to retrieve account information
 *
 * @author Goutham Nyalakonda
 * @version 1.0
 */
@RestController
@RequestMapping("accounts")
public class AccountController {
    /**
     * Service to retrieve the account information
     */
    @Autowired
    private AccountService service;

    /**
     * Returns and account for given account id.
     * @param accountId
     * @return
     */
    @GetMapping("{id}")
    @ResponseBody
    public AccountDto getAccount(@PathVariable("id") long accountId) {
        System.out.println("Retriving Account for Id :" + accountId);
        Optional<AccountDto> account = null;
        try {
            account = service.getAccount(accountId);
        } catch (Throwable t) {
            throw new ServerException(t);
        }
        return account.orElseThrow(() -> new DataNotFoundException());
    }
}

