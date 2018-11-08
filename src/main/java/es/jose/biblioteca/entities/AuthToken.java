package es.jose.biblioteca.entities;

/**
 * @since 08-nov-2018
 * @author joseb85
 */
public class AuthToken {

    private String token;

    public AuthToken() {

    }

    public AuthToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
