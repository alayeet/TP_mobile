package tp_mobile.tp_mobile;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller{

    static final String BASE_URL = "https://api.thecatapi.com/v1/images/";
    private List<Cat> results;
    private MainActivity view;

    public Controller(MainActivity view){
        this.view = view;
    }

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CatAPI gerritAPI = retrofit.create(CatAPI.class);
        Call<List<Cat>> call = gerritAPI.getCatList();
        call.enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
                if(response.isSuccessful()) {
                    results = response.body();
                } else {
                    System.out.println(response.errorBody());
                }
                view.showList(results);
            }

            @Override
            public void onFailure(Call<List<Cat>> call, Throwable t) {
                view.showList(results);
            }
        });
    }

}