package cbp.ace.truck.account.service;

import cbp.ace.truck.account.dto.AccountDto;
import cbp.ace.truck.account.model.Account;
import cbp.ace.truck.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Account Service database implementation
 *
 * @author Goutham Nyalakonda
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository repo;

    /**
     * Retrieve account
     * @param id
     * @return
     */
    @Override
    public Optional<AccountDto> getAccount(long id) {
        Optional<Account> account = repo.findById(id);
        AccountDto dto = null;
        if (account.isPresent()) {
            dto = new AccountDto();
            dto.setAccountId(account.get().getAccountId());
            dto.setFirstName(account.get().getFirstName());
            dto.setLastName(account.get().getLastName());
        }
        return Optional.ofNullable(dto);
    }
}
