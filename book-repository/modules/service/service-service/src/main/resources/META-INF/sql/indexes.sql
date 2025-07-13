create index IX_76948560 on BookServiceBuilder_Author (name[$COLUMN_LENGTH:75$]);

create index IX_9C1B30AC on BookServiceBuilder_Book (categoryId[$COLUMN_LENGTH:75$]);
create index IX_8D6A2C6 on BookServiceBuilder_Book (subtitleId[$COLUMN_LENGTH:75$]);
create index IX_FD3C5DE9 on BookServiceBuilder_Book (title[$COLUMN_LENGTH:75$]);

create index IX_4AC6A964 on BookServiceBuilder_BookAuthor (authorId[$COLUMN_LENGTH:75$]);

create index IX_D6AE49D3 on BookServiceBuilder_Category (name[$COLUMN_LENGTH:75$]);

create index IX_B5CF1EED on BookServiceBuilder_Subtitle (name[$COLUMN_LENGTH:75$]);