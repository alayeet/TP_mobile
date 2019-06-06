package tp_mobile.tp_mobile.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import tp_mobile.tp_mobile.Model.Cat;

public interface CatAPI {
    @GET("search?limit=10")
    Call<List<Cat>> getCatList();
}
