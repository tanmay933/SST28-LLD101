#  Pluggable Rate Limiter System

## Overview
This project is a clean and practical implementation of a rate limiter designed for backend systems where external API calls cost money.

Instead of limiting every incoming request, this system applies rate limiting only when an external resource is about to be called. This keeps it efficient and aligned with real-world usage.

The system is designed with strong emphasis on SOLID principles and extensibility.

---

## Features
- Multiple rate limiting strategies:
  - Fixed Window
  - Sliding Window
- Easy switching between algorithms (no business logic change)
- Flexible keying:
  - Per tenant
  - Per API key
  - Per user
- Thread-safe implementation
- Clean modular structure

---

## How it works (simple flow)

A request comes in → business logic runs →  
only if an external call is needed → rate limiter is checked.

Client Request  
→ Business Logic  
→ External call needed?  
→ YES → RateLimiterService  
→ Allowed → call external API  
→ Blocked → reject / handle  

---

## Design (high-level idea)

The system is split into clear responsibilities:

- RateLimiterService → main entry point  
- KeyGenerator → decides *who* to limit  
- RateLimitingStrategy → decides *how* to limit  

Structure:

RateLimiterService  
├── KeyGenerator  
└── Strategy  
  ├── FixedWindow  
  └── SlidingWindow  

---

## Project Structure

rateLimiter/  
├── api/         → interfaces  
├── core/        → main logic  
├── strategy/    → algorithms  
├── model/       → configs  
├── store/       → storage abstraction  
├── key/         → key generation  
├── util/        → helpers  
├── exception/   → custom errors  
└── demo/        → runnable example  

---

## Switching Algorithms

Just change this line:

RateLimitingStrategy strategy = new FixedWindowStrategy(...);  
// or  
RateLimitingStrategy strategy = new SlidingWindowStrategy(...);  

No other changes required.

---

## Fixed vs Sliding Window

Fixed Window:
- Simple and fast  
- Allows burst at window boundaries  

Sliding Window:
- More accurate and fair  
- Slightly higher memory and computation  

---

## Design Principles Used

SRP → Each class has a single responsibility  
OCP → New strategies can be added without modifying existing code  
LSP → All strategies are interchangeable  
ISP → Small, focused interfaces  
DIP → Core depends on abstractions  

---

## Future Improvements
- Token Bucket / Leaky Bucket strategies  
- Redis-based distributed rate limiter  
- Dynamic configuration per tenant  
- Monitoring and metrics  

---

## Author
Tanmay Mittal