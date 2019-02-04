package cbp.ace.truck.account;


import cbp.ace.truck.account.dto.AccountDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountIntegrationTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testGetAccount(){
        String url = "http://localhost:" + port + "/accounts/1";
        AccountDto account = restTemplate.getForObject( url, AccountDto.class );
        Assert.assertNotNull(account);
        Assert.assertEquals(account.getFirstName(), "John");
        Assert.assertEquals(account.getLastName(), "Doe");
        Assert.assertEquals(account.getAccountId(), 1);
    }
}
