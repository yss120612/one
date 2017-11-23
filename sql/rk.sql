--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-11-23 12:26:55

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 207 (class 1259 OID 17359)
-- Name: k_raions; Type: TABLE; Schema: public; Owner: userpp
--

CREATE TABLE k_raions (
    kodr integer NOT NULL,
    koef numeric(7,1) NOT NULL,
    rgn character varying(30),
    dst character varying(60)
);


ALTER TABLE k_raions OWNER TO userpp;

--
-- TOC entry 2181 (class 0 OID 17359)
-- Dependencies: 207
-- Data for Name: k_raions; Type: TABLE DATA; Schema: public; Owner: userpp
--

COPY k_raions (kodr, koef, rgn, dst) FROM stdin;
3002	1.3	Республика Бурятия  	Баунтовский                                               
3013	1.3	Республика Бурятия  	Муйский                                                   
3017	1.3	Республика Бурятия  	Северо-Байкальский                                        
9011	1.3	Республика Карелия  	Медвежьегорский                                           
9006	1.3	Республика Карелия  	Муезерский                                                
9004	1.3	Республика Карелия  	Пудожский                                                 
9014	1.3	Республика Карелия  	 г. Сегежа                                                
7018	1.3	Республика Коми     	Ижемский                                                  
7006	1.3	Республика Коми     	Печорский, Печора                                         
7014	1.3	Республика Коми     	Троицко-Печорский                                         
7019	1.3	Республика Коми     	Усть-Цилемский                                            
7016	1.3	Республика Коми     	Удорский                                                  
7020	1.3	Республика Коми     	Вуктыл                                                    
7022	1.3	Республика Коми     	Сосногорск                                                
7007	1.3	Республика Коми     	Ухта                                                      
7021	1.3	Республика Коми     	Усинск                                                    
34028	1.3	Красноярский край   	Богучанский                                               
34013	1.3	Красноярский край   	Енисейский                                                
34039	1.3	Красноярский край   	Кежемский                                                 
34044	1.3	Красноярский край   	Мотыгинский                                               
34051	1.3	Красноярский край   	 Северо-Енисейский                                        
34053	1.3	Красноярский край   	Туруханский (южнее рек Нижняя Тунгуска и Турухан) районы  
34061	1.3	Красноярский край   	Лесосибирск                                               
48008	1.3	Иркутская область   	Бодайбинский                                              
48009	1.3	Иркутская область   	Братский                                                  
48015	1.3	Иркутская область   	Казачинско-Ленский                                        
48016	1.3	Иркутская область   	Катангский                                                
48034	1.3	Иркутская область   	Киренский                                                 
48019	1.3	Иркутская область   	 Мамско-Чуйский                                           
48021	1.3	Иркутская область   	Нижнеилимский                                             
48028	1.3	Иркутская область   	Усть-Кутский                                              
48027	1.3	Иркутская область   	Усть-Илимск                                               
\.


-- Completed on 2017-11-23 12:27:02

--
-- PostgreSQL database dump complete
--
