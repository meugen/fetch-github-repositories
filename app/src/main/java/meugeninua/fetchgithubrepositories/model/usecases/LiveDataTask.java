package meugeninua.fetchgithubrepositories.model.usecases;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class LiveDataTask<T> extends FutureTask<T> {

    private static final String TAG = LiveDataTask.class.getSimpleName();

    private final MutableLiveData<Result<T>> liveData;

    public LiveDataTask(
            final Callable<T> callable,
            final MutableLiveData<Result<T>> liveData) {
        super(callable);
        this.liveData = liveData;
    }

    @Override
    protected void set(final T data) {
        super.set(data);
        liveData.postValue(Result.withResult(data));
    }

    @Override
    protected void setException(final Throwable error) {
        super.setException(error);
        liveData.postValue(Result.withError(error));
        Log.e(TAG, error.getMessage(), error);
    }
}
