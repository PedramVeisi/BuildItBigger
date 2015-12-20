package si.vei.pedram.androidjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        TextView jokeTextView = (TextView) findViewById(R.id.library_joke_textview);
        String joke = getIntent().getStringExtra(getString(R.string.INTENT_JOKE_STRING));

        jokeTextView.setText(joke);

    }
}
