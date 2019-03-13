package meugeninua.fetchgithubrepositories.model.usecases.impls;

import retrofit2.Response;

public class ServerErrorException extends Exception {

    public final int errorCode;
    public final String message;

    ServerErrorException(final Response<?> response) {
        errorCode = response.code();
        message = response.message();
    }
}
