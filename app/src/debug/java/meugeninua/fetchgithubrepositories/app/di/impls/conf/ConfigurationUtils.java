package meugeninua.fetchgithubrepositories.app.di.impls.conf;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ConfigurationUtils {

    private ConfigurationUtils() {}

    public static void configureOkHttpBuilder(final OkHttpClient.Builder builder) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
    }
}
