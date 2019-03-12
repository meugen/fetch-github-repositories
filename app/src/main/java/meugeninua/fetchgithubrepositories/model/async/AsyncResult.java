package meugeninua.fetchgithubrepositories.model.async;

public class AsyncResult<T> {

    private final T data;
    private final Exception error;

    private AsyncResult(
            final T data,
            final Exception error) {
        this.data = data;
        this.error = error;
    }

    public AsyncResult(final T data) {
        this(data, null);
    }

    public AsyncResult(final Exception ex) {
        this(null, ex);
    }

    public T getData() throws Exception {
        if (error != null) {
            throw error;
        }
        return data;
    }
}
