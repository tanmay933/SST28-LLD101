package rateLimiter.demo;

import rateLimiter.api.*;
import rateLimiter.core.RateLimiterFactory;
import rateLimiter.core.RateLimiterService;
import rateLimiter.strategy.fixedwindow.FixedWindowStrategy;

public class RateLimiterDemo {

    public static void main(String[] args) throws InterruptedException {

        // 5 requests per 10 seconds
        FixedWindowStrategy strategy = new FixedWindowStrategy(5, 10_000);

        RateLimiterService rateLimiter = RateLimiterFactory.create(strategy);

        String key = "tenant_1";

        for (int i = 1; i <= 10; i++) {
            RateLimitRequest request = new RateLimitRequest(key);

            RateLimitResponse response = rateLimiter.isAllowed(request);

            if (response.isAllowed()) {
                System.out.println("Request " + i + " ALLOWED");
            } else {
                System.out.println("Request " + i + " BLOCKED");
            }

            Thread.sleep(1000);
        }
    }
}