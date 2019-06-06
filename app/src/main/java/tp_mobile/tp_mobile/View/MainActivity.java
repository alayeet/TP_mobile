package tp_mobile.tp_mobile.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import java.util.List;

import tp_mobile.tp_mobile.Model.Cat;
import tp_mobile.tp_mobile.Controller.Controller;
import tp_mobile.tp_mobile.R;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler_view);

        controller = new Controller(this);
        controller.start();
    }

    public void showList(List<Cat> test) {
        if (test != null) {
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            mAdapter = new MyAdapter(test, getBaseContext(), getListener());
            recyclerView.setAdapter(mAdapter);
        }
    }

    private MyAdapter.OnItemClickListener getListener() {
        return new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Cat item) {
                controller.OnItemClic(item);
            }
        };
    }

    public void changeActivity(String json) {
        Intent catIntent = new Intent(this, CatActivity.class);
        catIntent.putExtra("STARF", json);
        startActivity(catIntent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void leClic(View view){
        controller.start();
    }
}