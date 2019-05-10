package meugeninua.fetchgithubrepositories.model.usecases.impls;

import java.io.IOException;
import java.util.concurrent.Callable;

import meugeninua.fetchgithubrepositories.model.json.readers.EntityReader;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class CallUseCase<T> implements Callable<T> {

    private final Call call;
    private final EntityReader<T> entityReader;

    public CallUseCase(
            final Call call,
            final EntityReader<T> entityReader) {
        this.call = call;
        this.entityReader = entityReader;
    }

    @Override
    public T call() throws Exception {
        Response response = call.execute();
        if (!response.isSuccessful()) {
            throw new ServerErrorException(response);
        }
        ResponseBody body = response.body();
        if (body == null) {
            throw new IOException("No content");
        }
        return entityReader.read(body.charStream());
    }
}
