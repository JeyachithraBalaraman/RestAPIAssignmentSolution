
-- Insert Data into ROLES Table
INSERT INTO roles VALUES (1, 'ADMIN');
INSERT INTO roles VALUES (2, 'USER');


-- Insert data into USERS Table
INSERT INTO users VALUES (1,'$2a$12$wLEJ0bunzQ07jV1.UkdoKuAuFJViqx/lokXj7VE9oZ12dV0m1caGa','Chithra');
INSERT INTO users VALUES (2,'$2a$12$wLEJ0bunzQ07jV1.UkdoKuAuFJViqx/lokXj7VE9oZ12dV0m1caGa','Jeya');

--Insert data into users_roles
insert into users_roles values (1,1);
insert into users_roles values (2,2);
