package cbp.ace.truck.account.repository;

import cbp.ace.truck.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Data Account Interface tp retrieve the entities from Database
 *
 * @author Goutham Nyalakonda
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
