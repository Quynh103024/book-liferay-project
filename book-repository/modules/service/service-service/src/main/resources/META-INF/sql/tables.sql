create table BookServiceBuilder_Author (
	authorId VARCHAR(75) not null primary key,
	name VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table BookServiceBuilder_Book (
	bookId VARCHAR(75) not null primary key,
	title VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	thumbnail VARCHAR(75) null,
	published_year INTEGER,
	num_pages INTEGER,
	price INTEGER,
	stock INTEGER,
	subtitleId VARCHAR(75) null,
	categoryId VARCHAR(75) null
);

create table BookServiceBuilder_BookAuthor (
	bookId VARCHAR(75) not null,
	authorId VARCHAR(75) not null,
	createDate DATE null,
	modifiedDate DATE null,
	primary key (bookId, authorId)
);

create table BookServiceBuilder_Category (
	categoryId VARCHAR(75) not null primary key,
	name VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table BookServiceBuilder_Subtitle (
	subtitleId VARCHAR(75) not null primary key,
	name VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);