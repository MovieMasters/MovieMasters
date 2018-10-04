package businessLogic;

import datastorage.AccountDAO;
import domain.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountManager implements IManager {

    private final Map<String, Account> accountsMap;

    public AccountManager() {
        accountsMap = new HashMap<>();
    }

    @Override
    public Account find(String username) {
        Account account = accountsMap.get(username);

        if (account == null) {
            // Account may not have been loaded from the database yet. Try to
            // do so.
            AccountDAO accountDAO = new AccountDAO();
            account = accountDAO.find(username);

            if (account != null) {
                //ToDo other things can be loaded here... or not.
                //SomeDAOObject someDAOObject = new SomeDAOObject();
                //List<DomainObject> objects = someDAOObject.find(key);
                //for (DomainObject object : objects) {
                //Account.addSomeObject(object);
                //}

                // Cache the account that has been read from the database, to
                // avoid querying the database each time a account is needed.
                accountsMap.put(username, account);
            }
        }
        return account;
    }

    @Override
    public Account login(String username, char[] password) {
        AccountDAO accountDAO = new AccountDAO();
        Account account = accountDAO.login(username, password);

        if (account != null) {
            accountsMap.put(username, account);
        }
        return account;
    }

    @Override
    public boolean remove(Account account) {
        boolean result = false;
        String username = account.getUsername();

        // Let the account remove itself as a domain object. Do this before
        // removing from the database. In case something goes wrong, we
        // still have the data in the database. If first the account was
        // removed from the database, we might end up in an inconsistent
        // state.

        result = account.remove();

        if (result) {
            // Let the account remove itself from the database.
            AccountDAO accountDAO = new AccountDAO();
            result = accountDAO.remove(account);

            // ToDo In case something goes wrong here, we need to rollback.
        }

        // Finally, remove the account from the map in this manager.
        accountsMap.remove(username);

        return result;
    }
}
