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

SET SQL_SAFE_UPDATES = 0;
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
insert into Person (personCode, firstName, lastName, brokerType, fee, commissionRate, addressId) values
("TEST", "John", "Doe", "J", 75, 1.25, (select addressId from Address where street = "testStreet"));

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
insert into Asset (assetName, assetType, assetCode, apr, quarterlydividend,
					baseReturn, omegaMeasure,totalValue, stockSymbol, sharePrice) values
("TEST ASSET Co.", "P", "TEST1", null, 1000, 5, .35, 10000, null, null);

-- Test Query #10
insert into Portfolio (portfolioCode, personId, brokerId, beneficiaryId) values
("PT004", (select personId from Person where personCode = "R555RD"), (select personId from Person where personCode = "TEST"), null);

-- Test Query #11
insert into PortfolioAsset (portfolioId, assetId, value) values 
((select portfolioId from Portfolio where portfolioCode = "PT004"), (select assetId from Asset where assetCode = "TEST1"), 50);

-- Test Query #12
select p.firstName, p.lastName, count(p.personId) as numPortfolios from Person p
join Portfolio po on po.personId = p.personId group by p.personId;

-- Test Query #13
select p.firstName, p.lastName, count(brokerId) as numPortfolios from Person p
join Portfolio po on po.brokerId = p.personId group by p.personId;

select * from Portfolio;
select * from Person;

-- Test Query #14
select p.portfolioCode, a.assetCode from Asset a
join PortfolioAsset pa on pa.assetId = a.assetId
join Portfolio p on p.portfolioId = pa.portfolioId
where a.assetCode = "S";

-- Test Query #15


select * from PortfolioAsset;


