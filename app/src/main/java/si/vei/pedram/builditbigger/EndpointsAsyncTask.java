package si.vei.pedram.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.R;

import java.io.IOException;

import si.vei.pedram.Joker;
import si.vei.pedram.androidjokes.DisplayJoke;
import si.vei.pedram.builditbigger.backend.jokeApi.JokeApi;

class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static JokeApi mApiService = null;
    private Context mContext;

    @Override
    protected String doInBackground(Context... params) {
        if(mApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            mApiService = builder.build();
        }

        mContext = params[0];

        try {
            return mApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(mContext, DisplayJoke.class);
        intent.putExtra(mContext.getString(R.string.INTENT_JOKE_STRING), new Joker().getJoke());

        mContext.startActivity(intent);
    }
}