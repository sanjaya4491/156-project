use sdhakal;

-- Test Query #1
select * from Person;

-- Test Query #2
select p.firstName, p.lastName, e.email from Person p
left join Email e on p.personId = e.personId
where p.lastName = "Sickling";

-- Test Query #3
insert into Email(email, personId) values 
("TestEmail@TEST.com", (select personId from Person where lastName = "Carress"));

-- Test Query #4
update Email set email = "ChangeEmail@TEST.com" where email = "ldeangelis3@weebly.com";
select * from Email;
select * from Portfolio;

-- Test Query #5
delete from PortfolioAsset where portfolioId = (select portfolioId from Portfolio where personId = (select personId from Person where personCode = "PK9B"));
delete from Portfolio where personId = (select personId from Person where personCode = "PK9B");
delete from Email where personId = (select personId from Person where personCode = "PK9B");
delete from Person where personCode = "PK9B";

-- Test Query #6
insert into State (state, countryId) values
("CA", (select countryId from Country where country = "USA"));
insert into Address (street, city, zipCode, stateId) values 
("testStreet", "testCity", 12345, (select stateId from State where state = "CA"));
insert into Person (personCode, firstName, lastName, brokerType, addressId) values
("TEST", "John", "Doe", "J", (select addressId from Address where street = "testStreet"));

-- Test Query #7
select p.portfolioCode, a.assetCode from Asset a
join PortfolioAsset pa on pa.assetId = a.assetId
join Portfolio p on p.portfolioId = pa.portfolioId
where p.portfolioCode = "PT001";

-- Test Query #8
select pe.firstName, pe.lastName, a.assetCode from Asset a
join PortfolioAsset pa on pa.assetId = a.assetId
join Portfolio p on p.portfolioId = pa.portfolioId
join Person pe on pe.personId = p.personId
where pe.personCode = "UIMG";

-- Test Query #9
insert into Asset (assetName, assetType, assetCode, apr, quarterlydividend ,
					baseReturn ,omegaMeasure ,totalValue ,stockSymbol ,sharePrice) values
("TEST ASSET Co.", "P", "AME21", null, 1000, 2 , -0.15, 4333, null, null);

-- Test Query #10
insert into Portfolio (portfolioCode, personId, brokerId, beneficiaryId) values
("PT004", (select personId from Person where personCode = "R555RD"), (select personId from Person where personCode = "TEST"), null);




