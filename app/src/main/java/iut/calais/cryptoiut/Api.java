package iut.calais.cryptoiut;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("ticker")
    Call<List<CoinInfo>> getCoins(@Query("limit") int limit);

}
