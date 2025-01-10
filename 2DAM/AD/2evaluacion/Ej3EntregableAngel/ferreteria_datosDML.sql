
USE `ferreteria`;

--
-- Dumping data for table `articulos`
--

LOCK TABLES `articulos` WRITE;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT INTO `articulos` VALUES ('E001','MAQ-1','Soldador JBC 100w',NULL,0,1,124,'2006-09-11 00:00:00','\0'),('E002','ELEC','Soldador JBC 25W','temaño pequeño',0,1,89,'2006-09-11 00:00:00','\0'),('E003','ELEC','Tester Promax',NULL,0,1,123,'2006-09-11 00:00:00','\0'),('E004','ELEC','Tester Fluke',NULL,0,1,200,'2006-09-11 00:00:00','\0'),('E005','ELEC','Toma Tv Bticino',NULL,0,5,38,'2006-09-11 00:00:00',''),('H001','HOGAR','Sarten redonda 65mm',NULL,0,1,89,'2006-09-11 00:00:00','\0'),('H002','HOGAR','Torradora 80mm',NULL,0,1,122,'2006-09-11 00:00:00','\0'),('H003','HOGAR','Cubo basura 25l',NULL,0,1,78,'2006-09-11 00:00:00','\0'),('H004','HOGAR','Tapon bañera 23mm',NULL,0,2,23,'2006-09-11 00:00:00','\0'),('H005','HOGAR','Soporte Tv','doble pieza de acero',0,1,78,'2006-09-11 00:00:00','\0'),('L001','LUZ','Bombilla 25W',NULL,0,1,10,'2006-09-11 00:00:00','\0'),('L002','LUZ','Bombilla 100W',NULL,0,1,11,'2006-09-11 00:00:00','\0'),('L003','LUZ','Tubo fluorescente',NULL,0,1,34,'2006-09-11 00:00:00','\0'),('L004','LUZ','Downlight 100W',NULL,0,1,56,'2006-09-11 00:00:00','\0'),('M001','MAQ-1','Taladro Acme 100W',NULL,0,1,120,'2006-09-11 00:00:00','\0'),('M002','MAQ-1','Destornillador acme',NULL,0,1,23,'2006-09-11 00:00:00','\0'),('M003','MAQ-2','Martillo electrico 1000W',NULL,0,1,234,'2006-09-11 00:00:00','\0'),('T001','TOR-E','Tornillos estrella 8mm',NULL,0,100,10,'2006-09-11 00:00:00','\0'),('T002','TOR-E','Tornillos estrella 12mm',NULL,0,100,12,'2006-09-11 00:00:00','\0'),('T003','TOR-N','Tornillos normales 8mm',NULL,0,100,12,'2006-09-11 00:00:00','\0'),('T004','TOR-E','Tornillos cabeza ancha',NULL,0,50,3,'2004-05-10 00:00:00','\0');
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `cab_ped`
--

LOCK TABLES `cab_ped` WRITE;
/*!40000 ALTER TABLE `cab_ped` DISABLE KEYS */;
INSERT INTO `cab_ped` VALUES (1,2006,'2006-01-01 00:00:00',1,'CHE'),(2,2006,'2006-02-01 00:00:00',2,NULL);
/*!40000 ALTER TABLE `cab_ped` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'A12345673','Pepe','Gonzalez Bueno','964556645','964678764','C/Pintor Sorolla,8','12530','CON'),(2,'B12345674','Jose Vte.','Navarro Gomez','964556646','964678764','C/Pla,9','12540','CHE'),(3,'A12345675','Luis','Tena Rodrigez','964556647','964678764','C/El Raval,98','46035','PAG'),(4,'A12345676','Santiago','Piquer Alamilla','964556648','964678764','C/Martinez Gavara,78','46260','MES'),(5,'A64345678','Rebeca','Sorribes Garcia','964556649','964678764','C/Alberto Figueroa,23','03500','SEM'),(6,'G64345679','Eva','Rosell Ventura','964556650','964678764','C/Buen Suceso,23','12580','CON'),(7,'A64345680','Jorge','Ribes Garcia','964556651','964678764','Avda. Mediterraneo s/n','12530','CON'),(8,'A64345681','David','Robles Nieto','964556652','964678764','Pol. Carabona s/n','46035','TRI'),(9,'J64345682','Joan','Moliner Llido','964556653','964678764','C/Escorredor,23','12540','BIM'),(10,'A64345683','Pablo','Guerola Burdeus','964556654','964678764','C/Finello,67','12530','CON'),(11,'M54345684','Alberto','Fuentes Morales','964556655','964678764','C/Europa,23','12580','CON'),(12,'O54345685','Roger','Motos Ruiz','964556656','964678764','C/Lluis Vives,23','03500','CHE'),(13,'A54345686','Rafa','Marti Ventura','964556657','964678764','C/Joan Martorell,7','46035','CON'),(14,'P54345687','Hernesto','Moliner Gonzalez','964556658','964678764','Avd. Chicharro s/n','12540','CON'),(15,'A54345688','Lucas','Tormos Meseger','964556659','964678764','C/Cinco de julio','46260','CON');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping data for table `familias`
--

LOCK TABLES `familias` WRITE;
/*!40000 ALTER TABLE `familias` DISABLE KEYS */;
INSERT INTO `familias` VALUES ('ALCA','Alcallatas',NULL),('ELEC','Material Electrico',NULL),('HOGAR','Material para el Hogar',NULL),('LUZ','Elementos luminosos',NULL),('MAQ-1','Maquinaria ligera',NULL),('MAQ-2','Maquinaria pesada',NULL),('PLAS','Plasticos',NULL),('TIRAF','Tirafondos',NULL),('TOR-E','Tornillos estrella',NULL),('TOR-N','Tornillos normales',NULL),('TUER','Tuercas',NULL),('VAR','varios',NULL);
/*!40000 ALTER TABLE `familias` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `formas_pago`
--

LOCK TABLES `formas_pago` WRITE;
/*!40000 ALTER TABLE `formas_pago` DISABLE KEYS */;
INSERT INTO `formas_pago` VALUES ('BIM','A dos meses',60),('CHE','Cheque',0),('CON','Contado',0),('MES','A un mes',30),('PAG','Pagare',0),('SEM','A 6 meses',180),('TRI','A tres meses',90);
/*!40000 ALTER TABLE `formas_pago` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `lin_ped`
--

LOCK TABLES `lin_ped` WRITE;
/*!40000 ALTER TABLE `lin_ped` DISABLE KEYS */;
INSERT INTO `lin_ped` VALUES (1,2006,'E001',16,50,2),(1,2006,'E002',8,25,1),(1,2006,'H001',16,100,5),(2,2006,'E001',16,23,1);
/*!40000 ALTER TABLE `lin_ped` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES ('AL','Alemania'),('CH','China'),('ES','España'),('EU','Estados unidos'),('FR','Francia'),('GB','Gran Bretaña'),('GR','Grecia'),('IT','Italia'),('JP','Japón'),('PR','Portugal2');
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Dumping data for table `poblaciones`
--

LOCK TABLES `poblaciones` WRITE;
/*!40000 ALTER TABLE `poblaciones` DISABLE KEYS */;
INSERT INTO `poblaciones` VALUES ('03500','Benidorm','03','03500'),('12000','Castellón','12','12000'),('12420','Barracas','12','12420'),('12530','Burriana','12','12530'),('12540','Vila-Real','12','12540'),('12550','Almazora','12','12550'),('12580','Benicarló','12','12580'),('46000','Valencia','46','46000'),('46035','Benimamet','46','46035'),('46260','Alberic','46','46260');
/*!40000 ALTER TABLE `poblaciones` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES ('01','Alava','ES'),('02','Albacete','ES'),('03','Alicante','ES'),('04','Almería','ES'),('05','Avila','ES'),('06','Badajoz','ES'),('07','Baleares','ES'),('08','Barcelona','ES'),('09','Burgos','ES'),('10','Cáceres','ES'),('100','Paris','FR'),('11','Cádiz','ES'),('12','Castellón','ES'),('120','Roma','IT'),('13','Ciudad real','ES'),('130','Lisboa','pr'),('14','Córdoba','ES'),('15','La Coruña','ES'),('16','Cuenca','ES'),('17','Gerona','ES'),('18','Granada','ES'),('19','Guadalajara','ES'),('20','Guipuzcua','ES'),('21','Huelva','ES'),('22','Huesca','ES'),('23','Jaen','ES'),('24','León','ES'),('25','Lérida','ES'),('26','La Rioja','ES'),('27','Lugo','ES'),('28','Madrid','ES'),('29','Málaga','ES'),('30','Murcia','ES'),('31','Navarra','ES'),('32','Orense','ES'),('33','Asturias','ES'),('34','Palencia','ES'),('35','Las Palmas','ES'),('36','Pontevedra','ES'),('37','Salamanca','ES'),('38','Tenerife','ES'),('39','Cantabria','ES'),('40','Segovia','ES'),('41','Sevilla','ES'),('42','Soria','ES'),('43','Tarragona','ES'),('44','Teruel','ES'),('45','Toledo','ES'),('46','Valencia','ES'),('47','valladolid','ES'),('48','Vizcaya','ES'),('49','Zamora','ES'),('50','Zaragoza','ES'),('51','Ceuta','ES'),('52','Melilla','ES');
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;


