CREATE TABLE USER_INFO (ID bigint not null, MAIL varchar(60) not null, PASSWORD varchar(60) not null,
                        NAME varchar(30), IS_PARKED bool not null, SAVED_PARKING_LOT_ID bigint, PAYMENT_ID bigint, primary key (ID));

CREATE TABLE PARKING_LOT
(ID bigint not null, NAME varchar(60) not null, PRICE_BY_HOUR bigint, location varchar(100) not null,
 primary key (ID));

CREATE TABLE PAYMENT (ID bigint not null, CARD_NUMBER int not null, WRITTEN_NAME varchar(60)
                                not null, EXPIRATION_TIME date not null, CCV int not null, primary key (ID));


CREATE TABLE PARKING_HISTORY (ID bigint not null, CHECK_IN_TIME date not null, CHECK_OUT_TIME date,
                              PARKING_LOT_ID bigint not null, PRICE_AMOUNT int, LICENSE_PLATE_ID bigint not null,
                              USER_ID bigint not null, primary key (ID));

CREATE TABLE LICENSE_PLATE (ID bigint not null, LICENSE_PLATE_DATA varchar(60) not null,
                            primary key (ID));

CREATE TABLE PARKING_SPACE (ID bigint not null, DESCRIPTION varchar(5) not null, IS_EMPTY bool,
                            FLOOR int not null, primary key (ID));

CREATE TABLE USER_PARKING_LOT (PARKING_LOT_ID bigint not null, USER_INFO_ID bigint not null);