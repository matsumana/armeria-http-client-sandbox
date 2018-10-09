package info.matsumana.sandbox.handler;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.server.annotation.Get;

import info.matsumana.sandbox.retrofit.HttpClient;
import retrofit2.Retrofit;

@Component
public class RootHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final Retrofit retrofit;

    RootHandler(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Get("/")
    public CompletableFuture<HttpResponse> index() {
        final HttpClient client = retrofit.create(HttpClient.class);
        return client.index()
                     .thenApplyAsync(res -> HttpResponse.of(HttpStatus.OK, MediaType.HTML_UTF_8, res))
                     .exceptionally(e -> HttpResponse.of(HttpStatus.INTERNAL_SERVER_ERROR,
                                                         MediaType.PLAIN_TEXT_UTF_8,
                                                         e.toString()));
    }
}
