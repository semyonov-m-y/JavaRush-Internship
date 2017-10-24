DROP DATABASE IF EXISTS bookmanager;

CREATE DATABASE bookmanager;

USE bookmanager;

CREATE TABLE `books`
(
	`ID` INT(8) NOT NULL AUTO_INCREMENT,
	`BOOK_TITLE` VARCHAR(100) NOT NULL DEFAULT '0',
	`BOOK_AUTHOR` VARCHAR(255) NOT NULL DEFAULT '0',
	`BOOK_DESCRIPTION` VARCHAR(255) NOT NULL DEFAULT '0',
	`ISBT` INT NOT NULL DEFAULT '0',
	`PRINTYEAR` INT NOT NULL DEFAULT '0',
	`READALREADY` INT NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
)

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO `test` (`ID`,`BOOK_TITLE`,`BOOK_AUTHOR`,`BOOK_DESCRIPTION`,`ISBT`, `PRINTYEAR`, `READALREADY`) VALUES
(1,"How to speak correctly","Joseph Devlin","","1234567890","2000","0"),
(2,"Above life","James Allen","","1230567890","1999","0"),
(3,"The Trince","Niccolò Machiavelli","","1034567890","2017-01-01 18:04:23","0"),
(4,"Tarzan","Henry Stanton","","1234067890","2015","0"),
(5,"Lilya","Arnold Bennett","","0234567890","2007","0"),
(6,"The art of speaking","Dale Carnegie","","1234507890","2016","0"),
(7,"How to cook","Olive Green","","1234560890","2006","0"),
(8,"Hypnosis","Melvin Powers","","1234567090","2005","0"),
(9,"The game of life","Florence Scovel Shinn","","1234567800","2004","0"),
(10,"Troy","James Allen","","1134567890","2003","0"),
(11,"Common sense","Thomas Paine","","1214567890","2002","0"),
(12,"Hints for lovers","Theodore Arnold Haultain","","1231567890","2001","0"),
(13,"Blade","Unknown","","1234167890","2000","0"),
(14,"Beautiful girlhood","Mabel Hale","","1234517890","2000","0"),
(15,"How to punctuate","Paul Allardyce","","1234561890","2001","0"),
(16,"The wise woman","George MacDonald","","1234567190","2002","0"),
(17,"The Chaos","Gerard Nolst Trenité","","1234567810","2003","0"),
(18,"Pease of mind","Lucius Annaeus Seneca","","1234567891","2004","0"),
(19,"How to sing","Lilli Lehmann","","1224567890","2005","0"),
(20,"What dress makes of us","Dorothy Quigley","","2234567890","2006","0"),
(21,"Notes of nursing","Florence Nightingale","","1232567890","2007","0"),
(22,"The story of my misfortunes","Peter Abelard","","1234267890","2008","0"),
(23,"The complete book of cheese","Bob Brown","","1234527890","2009","0"),
(24,"Trips to the Moon","Lucian of Samosata","","1234562890","2010","0"),
(25,"Married love","Marie Stopes","","1234567290","2011","0"),
(26,"Sabotage","Elizabeth Gurley Flynn","","1234567820","2012","0"),
(27,"The keepsake","Unknown","","1234567892","2013","0"),
(28,"The science of being great","Wallace D. Wattles","","3234567890","2014","0"),
(29,"The speaking voice","Katherine Jewell Everts","","1334567890","2015","0"),
(30,"The art of travel","Sir Francis Galton","","1233567890","2016","0"),
(31,"The persian hidden words","Bahá","","1234367890","2017","0");