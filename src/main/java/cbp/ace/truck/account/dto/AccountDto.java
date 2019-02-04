package cbp.ace.truck.account.dto;

/**
 * Account Data Transfer Object
 *
 * @author Goutham Nyalakonda
 * @version 1.0
 */
public class AccountDto {
    private long accountId;
    private String firstName;
    private String lastName;

    /**
     * returns accountId
     * @return
     */
    public long getAccountId() {
        return accountId;
    }

    /**
     * populates accountId
     * @param accountId
     */
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    /**
     * returns lastname
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * populates firstname
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns lastname
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * populate lastname
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
