package info.matsumana.sandbox.retrofit;

import java.util.concurrent.CompletableFuture;

import retrofit2.http.GET;

public interface HttpClient {

    @GET("/")
    CompletableFuture<String> index();
}
