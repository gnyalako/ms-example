package cbp.ace.truck.account.service;

import cbp.ace.truck.account.dto.AccountDto;
import cbp.ace.truck.account.model.Account;
import cbp.ace.truck.account.repository.AccountRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AccountServiceTest.class)
public class AccountServiceTest {
    @Autowired
    private AccountService service;

    @Bean
    private AccountRepository repository() {
        AccountRepository repo = Mockito.mock(AccountRepository.class);
        Account account = new Account();
        account.setAccountId(1L);
        account.setFirstName("John");
        account.setLastName("Doe");
        Mockito.when(repo.findById(1L)).thenReturn(Optional.of(account));
        Mockito.when(repo.findById(2L)).thenReturn(Optional.ofNullable(null));
        return repo;
    }

    @Bean
    private AccountService accountService() {
        return new AccountServiceImpl();
    }

    @Test
    public void testGetAccount() {
        Optional<AccountDto> account = service.getAccount(1);
        Assert.assertNotNull(account);
        Assert.assertTrue(account.isPresent());
        Assert.assertEquals(account.get().getAccountId(), 1);
        Assert.assertEquals(account.get().getFirstName(), "John");
        Assert.assertEquals(account.get().getLastName(), "Doe");
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetAccountNotFound() {
        Optional<AccountDto> account = service.getAccount(2);
        Assert.assertNotNull(account);
        Assert.assertFalse(account.isPresent());
        account.get();
    }
}
