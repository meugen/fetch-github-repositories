package meugeninua.fetchgithubrepositories.model.async;

import java.util.concurrent.Callable;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LiveDataRunnable<T> implements Runnable {

    private final MutableLiveData<AsyncResult<T>> liveData;
    private final Callable<T> callable;

    public LiveDataRunnable(
            final MutableLiveData<AsyncResult<T>> liveData,
            final Callable<T> callable) {
        this.liveData = liveData;
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            T result = callable.call();
            liveData.postValue(new AsyncResult<T>(result));
        } catch (Exception e) {
            liveData.postValue(new AsyncResult<T>(e));
        }
    }
}
