CREATE KEYSPACE vehiclelocation
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE gpslocation(
    vin text,
   latitude decimal,
   longitude decimal,
   speed double,
   location text,
   timestamp timestamp,
   PRIMARY KEY(vin,timestamp)
   ) with CLUSTERING ORDER BY(timestamp DESC);
   
    CREATE TABLE vehicle(
   id timeuuid,
   vin varchar PRIMARY KEY,
   model varchar,
   make varchar,
   type varchar,
   isActive boolean,
   isRegistered boolean
   )
   
  insert into vehicle(vin,isRegistered,isActive)values('V-123',false,true);
   insert into vehicle(vin,isRegistered,isActive)values('V-456',false,true);
   
   

