CREATE SCHEMA `capture` ;
CREATE TABLE capture.Business(
	Business_Id MEDIUMINT NOT NULL AUTO_INCREMENT,
	Business_Name CHAR(30) NOT NULL,
	Business_Address CHAR(50) NOT NULL,
	Business_City CHAR(20) NOT NULL,
	Description CHAR(50) NULL,
    PRIMARY KEY (Business_Id)
);

CREATE TABLE capture.Business_Admin(
	User_Id CHAR(30) NOT NULL,
	Business_Id MEDIUMINT,
	User_Name CHAR(50) NOT NULL,
	Password CHAR(50) NOT NULL,
	Email CHAR(50) NOT NULL,
	Role CHAR(20) NOT NULL,
	Mobile_Number CHAR(20) NULL,
	Cellphone_Number CHAR(20) NULL,
	PRIMARY KEY (User_Id),
	FOREIGN KEY (Business_Id) REFERENCES Business(Business_Id)
);

CREATE TABLE capture.Customer(
	User_Id CHAR(20) NOT NULL,
	Business_Id MEDIUMINT,
	Name CHAR(30) NOT NULL,
	Address CHAR(100) NOT NULL,
	City CHAR(30) NULL,
	Email CHAR(40) NOT NULL,
	Mobile_Number CHAR(20) NOT NULL,
	Telephone_Number CHAR(20) NOT NULL,
	Parent tinyint,
	Customer_Type CHAR(30) NOT NULL,
	Parent_User_Id CHAR(20) NULL,
	PRIMARY KEY (User_Id),
	FOREIGN KEY(Business_Id) REFERENCES Business(Business_Id)
);

CREATE TABLE capture.Album(
	Album_Id MEDIUMINT AUTO_INCREMENT,
	Customer_User_Id CHAR(20),
	Location CHAR(40) NOT NULL,
	Title CHAR(50) NOT NULL,
	Name CHAR(50) NOT NULL,
	Description CHAR(200) NULL,
	Date TIMESTAMP,
	PRIMARY KEY(Album_Id),
	FOREIGN KEY(Customer_User_Id) REFERENCES Customer(User_Id)
);

CREATE TABLE capture.Media(
	Media_Id MEDIUMINT AUTO_INCREMENT,
	Album_Id MEDIUMINT,
	Media_Name CHAR(50) NOT NULL,
	Media_Location CHAR(50) NULL,
	Media_Type CHAR(30) NOT NULL,
	PRIMARY KEY(Media_Id),
	FOREIGN KEY(Album_Id) REFERENCES Album(Album_Id)
);

CREATE TABLE capture.Event(
	Event_Id MEDIUMINT AUTO_INCREMENT,
	Event_Album_Id MEDIUMINT,
	Customer_User_Id CHAR(20),
	Event_Name CHAR(50) NOT NULL,
	Event_Location CHAR(50) NOT NULL,
	Event_City CHAR(30) NULL,
	Event_Time TIMESTAMP,
	Event_Hashtag CHAR(30) NULL,
	Event_Description CHAR(200) NULL,
	PRIMARY KEY(Event_Id),
	FOREIGN KEY(Event_Album_Id) REFERENCES Album(Album_Id)
); 

CREATE TABLE capture.Event_RSVP(
	Event_Id MEDIUMINT,
	RSVP CHAR(10),
	Guest_Name CHAR(30) NOT NULL,
	Guest_Address CHAR(100) NOT NULL,
	Guest_Email_Address CHAR(50) NOT NULL,
	Guest_Mobile_Number CHAR(20), 
	No_Of_Guest INT,
    FOREIGN KEY (Event_Id) REFERENCES Event(Event_Id)
);


CREATE TABLE capture.Billing(
	Billing_Id MEDIUMINT AUTO_INCREMENT,
	Business_Id MEDIUMINT,
	Amount DOUBLE(16,2),
	Paid_By CHAR(50),
	Paid_Date TIMESTAMP,
	PRIMARY KEY(Billing_Id),
	FOREIGN KEY(Business_Id) REFERENCES Business(Business_Id)
);

CREATE TABLE capture.Comment(
	Comment_Id MEDIUMINT AUTO_INCREMENT,
	Album_Id MEDIUMINT,
	User_Id CHAR(50),
	Comment CHAR(255),
	Comment_Date TIMESTAMP,
	PRIMARY KEY(Comment_Id),
	FOREIGN KEY(Album_Id) REFERENCES Album(Album_Id)
);
