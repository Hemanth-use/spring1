package hero.sign_loginDto;

public class LoginRequest {

    private String usernameOrEmail;

    private String password;

    private String role;

    public LoginRequest(String usernameOrEmail, String password, String role) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
        this.role = role;
    }

    public LoginRequest() {
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "usernameOrEmail='" + usernameOrEmail + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
