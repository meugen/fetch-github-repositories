package meugeninua.fetchgithubrepositories.model.usecases;

public class UseCaseResult<T> {

    static <T> UseCaseResult<T> withResult(final T data) {
        return new UseCaseResult<>(data, null);
    }

    static <T> UseCaseResult<T> withError(final Exception ex) {
        return new UseCaseResult<>(null, ex);
    }

    public final T data;
    public final Exception error;

    private UseCaseResult(
            final T data,
            final Exception error) {
        this.data = data;
        this.error = error;
    }
}
