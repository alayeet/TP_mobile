package tp_mobile.tp_mobile.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import tp_mobile.tp_mobile.Model.Cat;
import tp_mobile.tp_mobile.R;

public class CatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        showCatImage();
    }

    private void showCatImage() {
        ImageView catImage = findViewById(R.id.catImage);
        Cat cat = new Gson().fromJson(getIntent().getStringExtra("STARF"), Cat.class);
        Picasso.with(getBaseContext()).load(cat.getUrl()).into(catImage);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
