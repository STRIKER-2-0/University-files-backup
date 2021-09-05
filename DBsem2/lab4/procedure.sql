CREATE OR REPLACE FUNCTION public.posts_insert_trigger()
  RETURNS trigger AS
$BODY$
	DECLARE
	table_master varchar(255):= 'posts';
	table_part varchar(255):= '';
	BEGIN
		table_part := table_master
		|| '_y' || date_part( 'year', NEW.publish_date )::text
		|| '_m' || date_part( 'month',NEW.publish_date )::text
		|| '_d' || date_part( 'day', NEW.publish_date )::text;
		PERFORM 1 FROM pg_class
		WHERE relname = table_part
		LIMIT 1;
		IF NOT FOUND
		THEN EXECUTE '
			CREATE TABLE ' || table_part || ' ( )
			INHERITS ( ' || table_master || ' )';
			EXECUTE '
			CREATE INDEX ' ||table_part || '_post_id_date_index
			ON ' || table_part || ' 
			USING btree (post_id, publish_date)';
		END IF;

		EXECUTE 'INSERT INTO ' || table_part || '
			SELECT(('||quote_literal(NEW)||')::'||TG_RELNAME||').*';
		RETURN NULL;
	END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.posts_insert_trigger()
  OWNER TO postgres;