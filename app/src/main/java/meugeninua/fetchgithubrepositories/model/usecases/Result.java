package meugeninua.fetchgithubrepositories.model.usecases;

public class Result<T> {

    static <T> Result<T> withResult(final T data) {
        return new Result<>(data, null);
    }

    static <T> Result<T> withError(final Throwable error) {
        return new Result<>(null, error);
    }

    public final T data;
    public final Throwable error;

    private Result(
            final T data,
            final Throwable error) {
        this.data = data;
        this.error = error;
    }
}
