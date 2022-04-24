package az.tarlan.fruits.clients;

import az.tarlan.fruits.web.models.FruitDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@ConfigurationProperties(value = "az.tarlan", ignoreUnknownFields = false)
public class FruitClient {

    private final String BEER_PATH_V1 = "/api/v1/fruit/";
    private String apihost;
    private final RestTemplate restTemplate;

    public FruitClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public FruitDto getFruitById(UUID fruitId) {
        return restTemplate.getForObject(apihost+BEER_PATH_V1+fruitId.toString(), FruitDto.class);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

}
