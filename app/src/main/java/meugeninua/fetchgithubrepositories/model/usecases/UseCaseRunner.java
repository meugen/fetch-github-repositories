package meugeninua.fetchgithubrepositories.model.usecases;

import java.util.concurrent.Callable;

import androidx.lifecycle.MutableLiveData;

public class UseCaseRunner<T> implements Runnable {

    private final MutableLiveData<UseCaseResult<T>> liveData;
    private final Callable<T> callable;

    public UseCaseRunner(
            final MutableLiveData<UseCaseResult<T>> liveData,
            final Callable<T> callable) {
        this.liveData = liveData;
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            T result = callable.call();
            liveData.postValue(UseCaseResult.withResult(result));
        } catch (Exception e) {
            liveData.postValue(UseCaseResult.<T>withError(e));
        }
    }
}
