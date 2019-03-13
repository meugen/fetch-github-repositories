package meugeninua.fetchgithubrepositories.model.usecases.impls;

import java.util.concurrent.Callable;

import retrofit2.Call;
import retrofit2.Response;

public class CallUseCase<T> implements Callable<T> {

    private final Call<T> call;

    public CallUseCase(final Call<T> call) {
        this.call = call;
    }

    @Override
    public T call() throws Exception {
        Response<T> response = call.execute();
        if (!response.isSuccessful()) {
            throw new ServerErrorException(response);
        }
        return response.body();
    }
}
