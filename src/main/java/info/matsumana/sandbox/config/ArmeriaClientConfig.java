package info.matsumana.sandbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.linecorp.armeria.client.retrofit2.ArmeriaRetrofitBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.java8.Java8CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Configuration
public class ArmeriaClientConfig {

    @Bean
    Retrofit retrofit() {
        return new ArmeriaRetrofitBuilder()
                .baseUrl("https://matsumana.info")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(Java8CallAdapterFactory.create())
                .build();
    }
}
