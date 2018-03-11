package service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service_api.ServiceGenerator;

public class GitHubServiceGenerator implements ServiceGenerator{

    private static final String BASE_URL = "https://api.github.com";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
