package cbp.ace.truck.account.service;

import cbp.ace.truck.account.dto.AccountDto;

import java.util.Optional;

/**
 * Account Service interface
 *
 * @author Goutham Nyalakonda
 */
public interface AccountService {
    Optional<AccountDto> getAccount(long id);
}
