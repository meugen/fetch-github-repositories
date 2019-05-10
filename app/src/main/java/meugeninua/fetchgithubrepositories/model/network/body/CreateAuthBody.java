package meugeninua.fetchgithubrepositories.model.network.body;

import java.util.List;

public class CreateAuthBody {

    public List<String> scopes;
    public String note;
    public String noteUrl;
    public String clientId;
    public String clientSecret;
    public String fingerprint;
}
