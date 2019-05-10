package meugeninua.fetchgithubrepositories.model.network.entities;

import java.util.Date;
import java.util.List;

public class AuthEntity {

    public int id;
    public String url;
    public List<String> scopes;
    public String token;
    public String hashedToken;
    public String note;
    public String noteUrl;
    public Date updatedAt;
    public Date createdAt;
}
