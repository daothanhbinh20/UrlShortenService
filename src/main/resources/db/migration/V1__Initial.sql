CREATE TABLE Customer (
    CustomerId INT NOT NULL,
    Email VARCHAR(100),
    Name VARCHAR(100),
    PhoneNumber VARCHAR(100)
);

INSERT INTO Customer (CustomerId, Email, Name, PhoneNumber)
VALUES (1, 'Test', 'Test', 'Test');