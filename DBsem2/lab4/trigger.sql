DROP TRIGGER IF EXISTS posts_insert_trigger ON posts;
CREATE TRIGGER posts_insert_trigger
BEFORE INSERT
ON posts
FOR EACH ROW
EXECUTE PROCEDURE posts_insert_trigger();