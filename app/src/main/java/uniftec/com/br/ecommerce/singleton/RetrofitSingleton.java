package uniftec.com.br.ecommerce.singleton;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by bruno.toniolo on 10/12/2017.
 */

public class RetrofitSingleton {
    private static RetrofitSingleton instance;

    private Retrofit retrofit;

    private RetrofitSingleton(){
        this.retrofit =  new Retrofit.Builder()
                .baseUrl("https://snackingapi.azurewebsites.net/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public static RetrofitSingleton getInstance(){
        if(instance == null){
            instance = new RetrofitSingleton();
        }

        return  instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
