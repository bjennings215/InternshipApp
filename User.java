public abstract class User {
    private String username;
    private String password;

    protected boolean createAccount(String username, String password)
    {
        return true;
    }
    
    protected boolean login(String username, String password)
    {
        return true;
    }
}