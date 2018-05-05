CREATE TABLE `books` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(50) DEFAULT NULL,
   `category` varchar(50) DEFAULT NULL,
   `price` int(11) DEFAULT NULL,
   `descript` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8
 
 CREATE TABLE `users` (
   `username` varchar(50) DEFAULT NULL,
   `password` varchar(50) DEFAULT NULL,
   `phone` varchar(50) DEFAULT NULL,
   `email` varchar(50) DEFAULT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8