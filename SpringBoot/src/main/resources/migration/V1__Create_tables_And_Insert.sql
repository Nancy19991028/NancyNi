
DROP TABLE IF EXISTS first.message;
CREATE TABLE first.message (
    id int NOT NULL primary key,
    username text NOT NULL,
    password text NOT NULL
);


INSERT INTO first.message VALUES ('1', 'admin', '$2a$10$V5iwRgfXKN10XuAuR4lng.uFCQMFmsPu00wa7.YN.9JQJdGH9LAeW');
INSERT INTO first.message VALUES ('2', 'UserInfo', '$2a$10$CU7Qh78LMsv5cjZ8dvaxC.47fjlWYIWldl2NKlf.ddIIFFSKd0vqu');
INSERT INTO first.message VALUES ('3', 'test', '$2a$10$9HDPxT93IDRw3WmNezFOzu9W/h0lBEDllTTDtSqMRf6RnB2TReXqW');
