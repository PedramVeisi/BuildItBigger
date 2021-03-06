package si.vei.pedram.builditbigger;

import android.test.AndroidTestCase;
import java.util.concurrent.TimeUnit;

/**
 * Created by pedram on 20/12/15.
 */
public class EndpointsAsyncTaskTest extends AndroidTestCase {
    public void testJokeIsReturned() {
        try {
            EndpointsAsyncTask jokeTask = new EndpointsAsyncTask(mContext, false);
            jokeTask.execute();
            String joke = jokeTask.get(30, TimeUnit.SECONDS);
            assertFalse(joke.isEmpty());
        } catch (Exception e) {
            fail(e.toString());
        }
    }
}
