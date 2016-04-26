package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.util.Pair;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by DG on 4/25/16.
 */
public class JokeRetrievalTest extends InstrumentationTestCase {

    private String jokeResult;


    public void testAsyncTaskCall() throws Throwable {
        final CountDownLatch signal = new CountDownLatch(1);

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                GetJokeAsyncTask getJokeAsyncTask = new GetJokeAsyncTask(){
                    @Override
                    protected void onPostExecute(String result) {
                        jokeResult = result;
                        signal.countDown();
                    }
                };

                getJokeAsyncTask.execute(new Pair<Context, String>(getInstrumentation().getContext(), ""));
            }

        });

        signal.await(10, TimeUnit.SECONDS);
        assertTrue(jokeResult != null && !jokeResult.isEmpty());
    }

}
