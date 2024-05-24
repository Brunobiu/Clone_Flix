--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.25
-- Dumped by pg_dump version 9.5.25

-- Started on 2024-05-23 12:17:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2122 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 183 (class 1259 OID 17631)
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE public.flyway_schema_history OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 17613)
-- Name: model_login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.model_login (
    id bigint NOT NULL,
    celular character varying(255) NOT NULL,
    cpf character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    nome_sobrenome character varying(255) NOT NULL,
    senha character varying(255) NOT NULL
);


ALTER TABLE public.model_login OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 17611)
-- Name: seq_model_login; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_model_login
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_model_login OWNER TO postgres;

--
-- TOC entry 2113 (class 0 OID 17631)
-- Dependencies: 183
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.flyway_schema_history (installed_rank, version, description, type, script, checksum, installed_by, installed_on, execution_time, success) FROM stdin;
1	1	<< Flyway Baseline >>	BASELINE	<< Flyway Baseline >>	\N	null	2024-05-23 12:15:01.476002	0	t
\.


--
-- TOC entry 2112 (class 0 OID 17613)
-- Dependencies: 182
-- Data for Name: model_login; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.model_login (id, celular, cpf, email, nome_sobrenome, senha) FROM stdin;
25	62994757240	7530238100	bruno17henrique@gmail.com	bruno	12345678419
28	62994757240	67530238100	bruno18henrique@gmail.com	bruno	12345678419
31	62994757240	167530238100	bruno19henrique@gmail.com	bruno	12345678419
32	62994757240	6546515651	cdscdscsd@gmail.com	bruno	12345678419
36	62994757240	753024381000	bruninho@gmail.com	Bruno Henrique	123445678419
37	62994757240	75301243810001	bruninho2@gmail.com	Bruno Henrique	123445678419
44	62994757240	753011243810001	bruninho3@gmail.com	Bruno Henrique	123445678419
50	62994757240	7530111243810001	bruninho31@gmail.com	Bruno Henrique	123445678419
52	62994757240	000000000000	lucas00000@gmail.com	Lucas Henrique	123445678419
54	62994757240	7530141112124138100011	bruninshnnhxzzho6@gmail.com	Brunocscscscs	123445671218419
55	62994757240	1111115411111114211411	testeObtcsaegbfrList14@gmail.com	tesvssacdvvsteObterList	123445671218419
57	62994757240	00000000561666421200001	lucashsdkcsahj00001@gmail.com	Lucas Henrique65161 zz	123445678419
58	62994757240	753014118412124138100011	bruninshcsannhxzzho6@gmail.com	Brun5656ocscscscs	123445671218419
61	62994757240	11111sd15411111114211411	testeObdstcsaegbfrList14@gmail.com	tesvssacdvvsteObterList	123445671218419
63	62994757240	000ds0000561666421200001	lucashdssdkcsahj00001@gmail.com	Lucas Henrique65161 zz	123445678419
64	62994757240	7530141ds18412124138100011	bruninsdhcsannhxzzho6@gmail.com	Brun5656ocscscscs	123445671218419
\.


--
-- TOC entry 2123 (class 0 OID 0)
-- Dependencies: 181
-- Name: seq_model_login; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_model_login', 66, true);


--
-- TOC entry 1995 (class 2606 OID 17639)
-- Name: flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);


--
-- TOC entry 1989 (class 2606 OID 17620)
-- Name: model_login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model_login
    ADD CONSTRAINT model_login_pkey PRIMARY KEY (id);


--
-- TOC entry 1991 (class 2606 OID 17624)
-- Name: uk_3hdtntugpdc0mvyttl46ig5j0; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model_login
    ADD CONSTRAINT uk_3hdtntugpdc0mvyttl46ig5j0 UNIQUE (email);


--
-- TOC entry 1993 (class 2606 OID 17622)
-- Name: uk_9ywlse2rtdff1j8j9a6mbj2xl; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model_login
    ADD CONSTRAINT uk_9ywlse2rtdff1j8j9a6mbj2xl UNIQUE (cpf);


--
-- TOC entry 1996 (class 1259 OID 17640)
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);


--
-- TOC entry 2121 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2024-05-23 12:17:46

--
-- PostgreSQL database dump complete
--

