package com.room.jetpack.async;

import android.os.AsyncTask;

import com.room.jetpack.R;

/**
 * Created by Pravesh Sharma on 19-06-2018.
 */

public class GenericAsynTask<T> extends AsyncTask<T, Void, Void> {

    public interface AsyncCallback<T> {
        void databaseAction(T args);
    }

    private AsyncCallback callback;

    public void setCallbackListener(AsyncCallback callback) {
        this.callback = callback;
    }


    @Override
    protected final Void doInBackground(T... ts) {
        callback.databaseAction(ts[0]);
        return null;
    }
}
