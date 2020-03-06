use sdhakal;

show tables;

drop table if exists Portfolio;
drop table if exists Asset;
drop table if exists PortfolioAsset;
drop table if exists Email;
drop table if exists Person;
drop table if exists Address;
drop table if exists State;
drop table if exists Country;



create table Country (
countryId int not null primary key auto_increment,
name varchar (255) not null
);

create table State(
stateId int not null primary key auto_increment,
name varchar (255),
countryId int not null,
foreign key (countryId) references Country(countryId)
);

create table Address(
addressId int not null primary key auto_increment,
street varchar(255) not null,
city varchar (255) not null,
zipCode int not null,
stateId int not null,
foreign key (stateId) references State (stateId)
);

create table Person (
personId int not null primary key auto_increment,
firstName varchar (255),
lastName varchar (255),
personCode int not null,
brokerType varchar (255),
addressId int not null,
foreign key (addressId) references Address(addressId)
);

create table Email(
emailId int not null primary key auto_increment,
email varchar (255),
personId int not null,
foreign key (personId) references Person (personId)
);





create table Asset(
assetId int not null primary key auto_increment,
name varchar(255) not null,
assetType varchar(255),
assetCode varchar (255)
);



create table Portfolio(
portfolioId int not null primary key auto_increment,
personId int not null,
brokerid int not null,
beneficiaryId int ,
portfolioCode varchar(255) not null,
foreign key (personId) references Person (personId)
);

create table PortfolioAsset (
portfolioAssetId int not null primary key auto_increment,
portfolioId int not null,
assetId int not null,
foreign key (portfolioId) references Portfolio (portfolioId),
foreign key (assetId) references Asset (assetId)
);

