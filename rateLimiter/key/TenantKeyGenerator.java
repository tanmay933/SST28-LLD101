package rateLimiter.key;

public class TenantKeyGenerator implements KeyGenerator {

    @Override
    public String generate(String tenantId) {
        return "TENANT_" + tenantId;
    }
}