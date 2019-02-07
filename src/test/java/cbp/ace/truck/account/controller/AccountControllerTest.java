package cbp.ace.truck.account.controller;

import cbp.ace.truck.account.dto.AccountDto;
import cbp.ace.truck.account.exceptions.DataNotFoundException;
import cbp.ace.truck.account.exceptions.ServerException;
import cbp.ace.truck.account.service.AccountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AccountControllerTest.class)
public class AccountControllerTest {

    @Autowired
    private AccountController accountController;

    @Bean
    private AccountService service() {
        AccountService service = Mockito.mock(AccountService.class);
        AccountDto dto = new AccountDto();
        dto.setAccountId(1);
        dto.setFirstName("John");
        dto.setLastName("Doe");

        Mockito.when(service.getAccount(1)).thenReturn(Optional.of(dto));
        Mockito.when(service.getAccount(2)).thenReturn(Optional.ofNullable(null));
        Mockito.when(service.getAccount(3)).thenThrow(new NullPointerException());
        return service;
    }

    @Bean
    private AccountController accountController() {
        return new AccountController();
    }

    @Test
    public void testGetAccount() {
        AccountDto result = accountController.getAccount(1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAccountId(), 1);
        Assert.assertEquals(result.getFirstName(), "John");
        Assert.assertEquals(result.getLastName(), "Doe");
    }

    @Test(expected = DataNotFoundException.class)
    public void testGetAccountDataFoundException() {
        accountController.getAccount(2);
    }

    @Test(expected = ServerException.class)
    public void testServiceException(){
        accountController.getAccount(3);
    }
}
