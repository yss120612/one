-- Function: public.browse_sp(character varying)
-- Функция обновления экрана с результатом запроса  --
CREATE OR REPLACE FUNCTION public.browse_sp(IN client character varying)
RETURNS TABLE(s1 character varying, s2 date, s3 numeric, s4 timestamp without time zone, s5 timestamp without time zone, s6 integer, s7 integer, s8 bigint) AS
$BODY$    
	SELECT vc_ins, pravo, pens, ts_q, ts_a, 
    CASE WHEN szi_new is null THEN 0 ELSE 1 END, CASE WHEN raschet is null THEN 0 ELSE 1 END, 
    id FROM public.spravka WHERE vc_client = client AND DATE(ts_q) = current_date ORDER BY id DESC;
$BODY$
LANGUAGE sql VOLATILE COST 100 ROWS 1000;
ALTER FUNCTION public.browse_sp(character varying) OWNER TO userpp;

-- Function: public.browse_sp2(character varying, character varying)
-- Функция поиска запроса по конкретнному СНИЛС   --
CREATE OR REPLACE FUNCTION public.browse_sp2(IN client character varying, IN snils character varying)
RETURNS TABLE(s1 character varying, s2 date, s3 numeric, s4 timestamp without time zone, s5 timestamp without time zone, s6 integer, s7 integer, s8 bigint) AS
$BODY$
	SELECT vc_ins, pravo, pens, ts_q, ts_a,  CASE WHEN szi_new is null THEN 0 ELSE 1 END, CASE WHEN raschet is null THEN 0 ELSE 1 END,  
	id FROM public.spravka 
	WHERE vc_client = client AND vc_ins = snils  ORDER BY id DESC; 
$BODY$
LANGUAGE sql VOLATILE COST 100 ROWS 1000;
ALTER FUNCTION public.browse_sp2(character varying, character varying) OWNER TO userpp;

-- Function: public.insert_q2(character varying, character varying, character varying)
-- Функция добавления запроса  в базу данных  --
CREATE OR REPLACE FUNCTION public.insert_q2(client character varying, snils character varying, ip character varying)
RETURNS integer AS '
DECLARE id_ integer DEFAULT NULL; 
BEGIN 
	SELECT id INTO id_ FROM public.spravka WHERE vc_client = client AND vc_ins = snils AND ts_q::date = current_date ; 
	IF id_ IS NULL THEN  
		INSERT INTO public.spravka (vc_client, vc_ins, ts_q, vc_ip) VALUES (client , snils, now(), ip) ; 
		RETURN 1 ; 
	ELSE 
		RETURN 0 ; 
	END IF; 
END ; '
LANGUAGE plpgsql VOLATILE COST 100;
ALTER FUNCTION public.insert_q2(character varying, character varying, character varying) OWNER TO userpp;

-- Function: public.load_pdf(bigint, integer)
-- Функция просмотра pdf файлов --
CREATE OR REPLACE FUNCTION public.load_pdf(id_ bigint, tp integer) 
RETURNS bytea AS
$BODY$
DECLARE pd_ bytea DEFAULT NULL;
BEGIN
    IF tp = 1 THEN
		SELECT szi_new INTO pd_ FROM public.spravka where id = id_ ;
    ELSE
        SELECT raschet INTO pd_ FROM public.spravka where id = id_ ;
    END IF;
    RETURN pd_ ;
END;
$BODY$
LANGUAGE plpgsql VOLATILE COST 100;
ALTER FUNCTION public.load_pdf(bigint, integer) OWNER TO userpp;

