CREATE TABLE exams (
	name VARCHAR(255),
	score INTEGER,
	exam_date DATE);
	
	
INSERT INTO exams VALUES 
	('Robbert', 85, '2017-06-01'),
	('John', 90, '2017-05-03'),
	('Nik', 71, '2017-06-14'),
	('Marcel', 88, '2017-01-11'),
	('Oana', 32, '2017-08-18'),
	('Oana', 24, '2017-09-01'),
	('Kenny', 60, '2017-08-21'),
	('Sheik', 52, '2017-09-08');


SELECT DISTINCT name, score, exam_date,
	CASE 
		WHEN (score >= 65) THEN 'Sucess'
		ELSE 'Fail'
	END
		AS Sucess,
	(score - LAG(score,1, score) OVER (ORDER BY exam_date)) 
		AS "impovement over pred"
FROM exams
ORDER BY exam_date;


SELECT INITCAP(name) AS "Certified"
FROM exams
WHERE NOT score < 65;
