package meugeninua.fetchgithubrepositories.model.network.services.impls;

import meugeninua.fetchgithubrepositories.BuildConfig;
import meugeninua.fetchgithubrepositories.model.json.writers.EntityWriter;
import meugeninua.fetchgithubrepositories.model.network.body.CreateAuthBody;
import meugeninua.fetchgithubrepositories.model.network.services.GithubService;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class GithubServiceImpl implements GithubService {

    private final OkHttpClient client;
    private final EntityWriter<CreateAuthBody> authBodyWriter;

    public GithubServiceImpl(
            final OkHttpClient client,
            final EntityWriter<CreateAuthBody> authBodyWriter) {
        this.client = client;
        this.authBodyWriter = authBodyWriter;
    }

    @Override
    public Call createAuthorization(final CreateAuthBody body, final String auth) {
        HttpUrl url = HttpUrl.parse(BuildConfig.GITHUB_API_URL)
                .newBuilder().encodedPath("/authorizations").build();
        Request request = new Request.Builder()
                .addHeader("Authorization", auth)
                .post(new JsonRequestBody<>(authBodyWriter, body))
                .url(url).build();
        return client.newCall(request);
    }

    @Override
    public Call getRepositories(final String auth, final String visibility) {
        HttpUrl url = HttpUrl.parse(BuildConfig.GITHUB_API_URL)
                .newBuilder().encodedPath("/user/repos")
                .addQueryParameter("visibility", visibility)
                .build();
        Request request = new Request.Builder()
                .addHeader("Authorization", auth)
                .get().url(url).build();
        return client.newCall(request);
    }
}
