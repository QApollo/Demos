CREATE TABLE exams (
	name VARCHAR(255),
	score INTEGER,
	exam_date DATE);
	
	
INSERT INTO exams VALUES ('Robbert', 85, '2017-06-01');
INSERT INTO exams VALUES ('John', 90, '2017-05-03');
INSERT INTO exams VALUES ('Nik', 71, '2017-06-14');
INSERT INTO exams VALUES ('Marcel', 88, '2017-01-11');
INSERT INTO exams VALUES ('Oana', 32, '2017-08-18');
INSERT INTO exams VALUES ('Oana', 24, '2017-09-01');
INSERT INTO exams VALUES ('Kenny', 60, '2017-08-21');
INSERT INTO exams VALUES ('Sheik', 52, '2017-09-08');


SELECT name, score, exam_date
	CASE WHEN (score >= 65) THEN 'Sucess'
		ELSE 'Fail'
	END AS Sucess,
	(score - LAG(score,1, score) OVER (ORDER BY exam_date)) 
		AS impov_over_predec
FROM exams
ORDER BY exam_date;