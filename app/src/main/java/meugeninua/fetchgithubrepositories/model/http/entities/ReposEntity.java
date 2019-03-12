package meugeninua.fetchgithubrepositories.model.http.entities;

import com.google.gson.annotations.SerializedName;

public class ReposEntity {

    @SerializedName("id")
    public int id;
    @SerializedName("node_id")
    public String nodeId;
    @SerializedName("name")
    public String name;
    @SerializedName("full_name")
    public String fullName;
    @SerializedName("private")
    public boolean isPrivate;
    @SerializedName("html_url")
    public String htmlUrl;
    @SerializedName("description")
    public String description;
    @SerializedName("fork")
    public boolean fork;
    @SerializedName("url")
    public String url;
    @SerializedName("fork_url")
    public String forkUrl;
    @SerializedName("keys_url")
    public String keysUrl;
    @SerializedName("collaborators_url")
    public String collaboratorUrl;
    @SerializedName("teams_url")
    public String teamsUrl;
    @SerializedName("hooks_url")
    public String hooksUrl;
    @SerializedName("issue_events_url")
    public String issueEventsUrl;
    @SerializedName("eventsUrl")
    public String eventsUrl;
    @SerializedName("assignees_url")
    public String assigneesUrl;
    @SerializedName("branches_url")
    public String branchesUrl;
    @SerializedName("tags_url")
    public String tagsUrl;
}
