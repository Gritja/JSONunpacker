package unpacker;

public class Users {
	
	//hanterar inlogg/användare-lösen

    private String userName = null;
    private String passWord = null;

    public Users() {
    }

    public Users(String firstName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getuserName() {
        return userName;
    }

    public void setFirstName(String userName) {
        this.userName = userName;
    }

    public String getpassWord() {
        return passWord;
    }

    public void setLastName(String passWord) {
        this.passWord = passWord;
    }
}