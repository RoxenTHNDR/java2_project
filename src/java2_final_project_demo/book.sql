DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
                        `bookID` int NOT NULL,
                        `title` varchar(100) NOT NULL,
                        `author` varchar(100) NOT NULL,
                        `bookread` bit NOT NULL,
                        `numpages` int NOT NULL,
                        `unitprice` decimal NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `book`
    ADD PRIMARY KEY (`bookid`);

ALTER TABLE `book`
    MODIFY `bookid` int(11) NOT NULL AUTO_INCREMENT;



DELIMITER $$
CREATE PROCEDURE sp_add_book(
    IN newtitle varchar(100),
    IN newauthor varchar(100),
    IN newread  bit,
    IN newnumpages int,
    IN newunitprice decimal
)
BEGIN
INSERT INTO book(
    title,
    author,
    bookread,
    numpages,
    unitprice
)
VALUES (
           newtitle,
           newauthor,
           newread,
           newnumpages,
           newunitprice
       );
END$$
DELIMITER ;

CALL sp_add_book('Harry Potter and the Chamber of Secrets','J.K. Rowling',true,341,22.99)
CALL sp_add_book('Ready Player One','Ernest Cline',true,374,17.0)

DELIMITER $$
CREATE PROCEDURE sp_get_all_books()
BEGIN
    SELECT * FROM book;
END$$
DELIMITER ;