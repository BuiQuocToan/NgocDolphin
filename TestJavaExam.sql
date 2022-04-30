DROP DATABASE IF EXISTS TestJavaExam;
CREATE DATABASE TestJavaExam;
USE TestJavaExam;

CREATE TABLE `User`(
ID			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
FullName	VARCHAR(100) UNIQUE KEY,
Email		VARCHAR(100) UNIQUE KEY,
`Password`	VARCHAR(100) CHECK(length(`Password`) >=6 AND length(`Password`) <=20),
ProjectId   INT UNSIGNED,
ExpInYear	INT UNSIGNED,
ProSkill	VARCHAR(100),
`Role`		ENUM('Manager', 'Employee')
);

INSERT INTO `User` 	(FullName 	,  Email				, `Password`, ProjectId ,ExpInYear	, ProSkill	, `Role`)
VALUES				('account1' , 'account1@gmail.com'	, 'account1',	1		,	3		,	NULL	,'Manager'),
					('account2' , 'account2@gmail.com'	, 'account2',	2		,	NULL	,	'Dev'	,'Employee'),
					('account3' , 'account3@gmail.com'	, 'account3',	1		,	1		,	NULL	,'Manager'),
                    ('account4' , 'account4@gmail.com'	, 'account4',	1		,	NULL	,	'Test'	,'Employee'),
					('account5' , 'account5@gmail.com'	, 'account5',	2		,	4		,	NULL	,'Manager');
