# Redis-Cache-with-Java-Spring <br>
<p>
 What is Redis? - Redis is an open-source, highly replicated, performant, non-relational kind of database and caching server.
It works by mapping keys to values with a sort of predefined data model.
Its benefits include: Mapped key-value-based caching system like MemeCache.</p>
<br>

# Getting Started

# To Run:
* Download Redis and run redis server.<br>
* Download Spring Web & Redis Dependency from Spring Initialiser<br>
* Run MVN clean, install as well as re-import when project opened<br>
* Download POSTMAN to quickly test the REST API created in personController.java via @RequestMapping<br>

#Architecture
-MAIN CLASS TO RUN: RedisApplication.java <br>
-Independant: Redis Configuration.java- binds the port & created REDIS template.<br>
-Service package: RedisListCache.java: takes in Key and Value(make it dynamic ofc) & RedisValueCache: Performs CRUD operation on the value<br>
-Controller package: PersonaContoller.java: Our access point for CACHE data so REST controller with API linked using @RequestMapping<br>
-DTO package: Datapoints- Has all fields(Name, ID, age) & constructor, implements interface bc REDIS data must be serialised.<br>

