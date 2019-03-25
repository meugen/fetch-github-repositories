package meugeninua.fetchgithubrepositories.model.network.body;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateAuthBody {

    @SerializedName("scopes")
    public List<String> scopes;
    @SerializedName("note")
    public String note;
    @SerializedName("note_url")
    public String noteUrl;
    @SerializedName("client_id")
    public String clientId;
    @SerializedName("client_secret")
    public String clientSecret;
    @SerializedName("fingerprint")
    public String fingerprint;
}
