package rateLimiter.key;

public class ApiKeyGenerator implements KeyGenerator {

    @Override
    public String generate(String apiKey) {
        return "APIKEY_" + apiKey;
    }
}