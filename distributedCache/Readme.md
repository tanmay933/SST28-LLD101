# Distributed Cache System

## Overview
This project implements a distributed cache system where data is spread across multiple cache nodes. It is designed to simulate real-world caching systems and focuses heavily on clean architecture, extensibility, and SOLID principles.

The system supports flexible strategies for deciding where data should be stored and how old data should be evicted when capacity is reached.

---

## Features
- Multiple cache nodes working together  
- Configurable number of nodes  
- Pluggable distribution strategy (currently modulo-based)  
- Pluggable eviction policy (LRU implemented)  
- Cache miss handling via database fallback  
- Write-through caching (database updated on put)  
- Easily extendable for future strategies  

---

## How it works (simple flow)

GET flow:

Client Request  
→ DistributedCacheService  
→ DistributionStrategy selects node  
→ CacheNode lookup  
→ Cache hit → return value  
→ Cache miss → fetch from Database  
→ Store in cache  
→ Return value  

PUT flow:

Client Request  
→ DistributedCacheService  
→ DistributionStrategy selects node  
→ CacheNode.put()  
→ If full → EvictionPolicy removes key  
→ Store new value  
→ Update database  

---

## Design (high-level idea)

The system is divided into independent components:

- DistributedCacheService → main orchestrator  
- DistributionStrategy → decides which node stores a key  
- CacheNode → stores key-value pairs  
- EvictionPolicy → manages removal when capacity is full  
- Database → fallback storage  

Structure:

DistributedCacheService  
├── DistributionStrategy  
├── List<CacheNode>  
│   └── EvictionPolicy (LRU)  
└── Database  

---

## Project Structure

distributedCache/  
├── controller/    → API layer  
├── service/       → core orchestration  
├── node/          → cache node implementation  
├── eviction/      → eviction logic (LRU)  
├── distribution/  → node selection logic  
├── repository/    → database abstraction  
├── model/         → data models  
├── factory/       → object creation  
├── config/        → configuration  
├── exception/     → custom exceptions  
└── Main.java      → entry point  

---


## Switching Strategies

To change distribution strategy:
Use a different implementation in DistributionStrategyFactory

To change eviction policy:
Use a different implementation in EvictionPolicyFactory

No changes required in service or node logic.

---

## LRU Eviction (Concept)

- Most recently used items stay in cache  
- Least recently used item gets removed first  
- Implemented using:
  - HashMap → O(1) access  
  - Doubly Linked List → O(1) updates  

---

## Design Principles Used

SRP → Each class has a single responsibility  
OCP → New strategies can be added without modifying existing code  
LSP → Strategies are interchangeable  
ISP → Interfaces are minimal and focused  
DIP → High-level modules depend on abstractions  

---

## Future Improvements
- Consistent hashing for better distribution  
- LFU / MRU eviction policies  
- Distributed network communication  
- Replication across nodes  
- Metrics and monitoring  

---

## Author
Tanmay Mittal