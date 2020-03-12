use sdhakal;
-- Authors: Daniel Godoy and Sanjaya Dhakal

-- Test Query #1 Retrieve the major fields for every person
select * from Person;

-- Test Query #2 Retrieve the email(s) of a given person
select p.firstName, p.lastName, e.email from Person p
left join Email e on p.personId = e.personId
where p.lastName = "Sickling";

-- Test Query #3 Add an email to a specific person
insert into Email(email, personId) values 
("TestEmail@TEST.com", (select personId from Person where lastName = "Carress"));

-- Test Query #4 Change the email address of a given email record
SET SQL_SAFE_UPDATES = 0;
update Email set email = "ChangeEmail@TEST.com" where email = "ldeangelis3@weebly.com";

-- Test Query #5 Remove a given person record
delete from PortfolioAsset where portfolioId = (select portfolioId from Portfolio where personId = (select personId from Person where personCode = "PK9B"));
delete from Portfolio where personId = (select personId from Person where personCode = "PK9B");
delete from Email where personId = (select personId from Person where personCode = "PK9B");
delete from Person where personCode = "PK9B";

-- Test Query #6 Create a person record
insert into State (state, countryId) values
("CA", (select countryId from Country where country = "USA"));
insert into Address (street, city, zipCode, stateId) values 
("testStreet", "testCity", 12345, (select stateId from State where state = "CA"));
insert into Person (personCode, firstName, lastName, brokerType, fee, commissionRate, addressId) values
("TEST", "John", "Doe", "J", 75, 1.25, (select addressId from Address where street = "testStreet"));

-- Test Query #7 Get all the assets in a particular portfolio
select p.portfolioCode, a.assetCode from Asset a
join PortfolioAsset pa on pa.assetId = a.assetId
join Portfolio p on p.portfolioId = pa.portfolioId
where p.portfolioCode = "PT002";

-- Test Query #8 Get all the assets of a particular person
select pe.firstName, pe.lastName, a.assetCode from Asset a
join PortfolioAsset pa on pa.assetId = a.assetId
join Portfolio p on p.portfolioId = pa.portfolioId
join Person pe on pe.personId = p.personId
where pe.personCode = "UIMG";

-- Test Query #9 Create a new asset record
insert into Asset (assetName, assetType, assetCode, quarterlydividend,
					baseReturn, omegaMeasure, totalValue) values
("TEST ASSET Co.", "P", "TEST1", 1000, 5, .35, 10000);

-- Test Query #10 Create a new portfolio record
insert into Portfolio (portfolioCode, personId, brokerId) values
("PT004", (select personId from Person where personCode = "R555RD"), 
(select personId from Person where personCode = "TEST"));

-- Test Query #11 Associate a particular asset with a particular portfolio
insert into PortfolioAsset (portfolioId, assetId, value) values 
((select portfolioId from Portfolio where portfolioCode = "PT004"), (select assetId from Asset where assetCode = "TEST1"), 50);

-- Test Query #12 Find the total number of portfolios owned by each person
select p.firstName, p.lastName, count(p.personId) as numPortfolios from Person p
join Portfolio po on po.personId = p.personId group by p.personId;

-- Test Query #13 Find the total number of portfolios managed by each person
select p.firstName, p.lastName, count(brokerId) as numPortfolios from Person p
join Portfolio po on po.brokerId = p.personId group by p.personId;

-- Test Query #14 Find the total value of all stocks in each portfolio
-- Add a stock to a different portfolio to better test the query
insert PortfolioAsset (portfolioId, assetId, value) values
((select portfolioId from Portfolio where portfolioCode = "PT002"), 
(select assetId from Asset where assetCode = "dadooe90"), 100);
    
select p.portfolioCode, sum(a.sharePrice * pa.value) as stockTotalValue from Asset a
join PortfolioAsset pa on pa.assetId = a.assetId
join Portfolio p on p.portfolioId = pa.portfolioId
where a.assetType = "S"
group by p.portfolioCode;

-- Test Query #15 Detect an invalid distribution of private investment assets (exceeding 100%)
-- Add private investments with values to exceed 100 to better test the query
insert into PortfolioAsset (portfolioId, assetId, value) values 
((select portfolioId from Portfolio where portfolioCode = "PT002"), (select assetId from Asset where assetCode = "TEST1"), 99),
((select portfolioId from Portfolio where portfolioCode = "PT001"), (select assetId from Asset where assetCode = "AME21"), 57);

select a.assetCode, sum(pa.value) as percentage from PortfolioAsset pa
join Portfolio po on pa.portfolioId = po.portfolioId
join Asset a on pa.assetId = a.assetId
where a.assetType = "P" 
group by a.assetCode
having sum(pa.value) > 100;