package meugeninua.fetchgithubrepositories.model.http.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class AuthEntity {

    @SerializedName("id")
    public int id;
    @SerializedName("url")
    public String url;
    @SerializedName("scopes")
    public List<String> scopes;
    @SerializedName("token")
    public String token;
    @SerializedName("hashed_token")
    public String hashedToken;
    @SerializedName("note")
    public String note;
    @SerializedName("note_url")
    public String noteUrl;
    @SerializedName("updated_at")
    public Date updatedAt;
    @SerializedName("created_at")
    public Date createdAt;
}
