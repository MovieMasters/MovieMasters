package businessLogic;

import domain.Account;

public interface IManager {

    /**
     * Tries to find the Account object matching the given username.
     *
     * @param username the account primary key
     * @return if a matching account was found, the account is returned,
     * null otherwise.
     */
    public Account find(String username);

    /**
     * Tries to find the Account object matching the given username.
     *
     * @param username the account primary key
     * @return if a matching account was found, the account is returned,
     * null otherwise.
     */
    public Account login(String username, char[] password);

    /**
     * Removes the given account from the system, including removal from the
     * persistent data store.
     *
     * @param account a reference to the member to be removed
     * @return true if removal was successful, false otherwise, i.e. when it was
     * not allowed to remove the account or when removal from the data store did
     * not succeed.
     */
    public boolean remove(Account account);
}
