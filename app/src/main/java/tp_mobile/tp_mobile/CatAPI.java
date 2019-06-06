package tp_mobile.tp_mobile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatAPI {

    @GET("search?limit=10")
    Call<List<Cat>> getCatList();
}
