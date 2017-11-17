SELECT comptype.ctpdescription, AVG(distances.cdsdistance)
FROM 
	 tbllbcompetitions competitions,
     tbllbcompdistances distances,
     tblcomptype comptype  
WHERE distances.cdscompetitionid = competitions.cmpid 
AND competitions.cmpcompetitiontype = comptype.ctpid
GROUP BY comptype.ctpdescription

SELECT *
FROM 
	 tbllbcompetitions competitions,
     tbllbcompdistances distances,
     tblcomptype comptype  
WHERE distances.cdscompetitionid = competitions.cmpid 
AND competitions.cmpcompetitiontype = comptype.ctpid
AND comptype.ctpdescription = 'NK Allround'

SELECT DISTINCT persons.prsfirstname || ' ' || persons.prslastname AS fullname
FROM 
	 tbllbcompetitions competitions,
     tbllbcompetitors competitors,
     tblpersons persons,
     tbllbcompdistances distances,
     tblcomptype comptype 
WHERE competitions.cmpid = competitors.cptcompetitionid 
AND competitors.cptpersonid = persons.prsid   
AND distances.cdscompetitionid = competitions.cmpid 
AND competitions.cmpcompetitiontype = comptype.ctpid
AND comptype.ctpdescription = 'NK Allround'

SELECT distinct persons.prsfirstname || ' ' || persons.prslastname AS fullname, persons.prsbirthdate
FROM 
	 tbllbcompetitions competitions,
     tbllbcompetitors competitors,
     tblpersons persons,
     tbllbcompdistances distances,
     tblcomptype comptype 
WHERE competitions.cmpid = competitors.cptcompetitionid 
AND competitors.cptpersonid = persons.prsid   
AND distances.cdscompetitionid = competitions.cmpid 
AND competitions.cmpcompetitiontype = comptype.ctpid
AND comptype.ctpdescription = 'NK Allround'
AND persons.prsbirthdate > 19000000
order by persons.prsbirthdate

SELECT to_date(prsbirthdate::text, 'YYYYMMDD')
FROM 
	 tbllbcompetitions competitions,
     tbllbcompetitors competitors,
     tblpersons persons,
     tbllbcompdistances distances,
     tblcomptype comptype 
WHERE competitions.cmpid = competitors.cptcompetitionid 
AND competitors.cptpersonid = persons.prsid   
AND distances.cdscompetitionid = competitions.cmpid 
AND competitions.cmpcompetitiontype = comptype.ctpid
AND comptype.ctpdescription = 'NK Allround'
AND persons.prsbirthdate > 19000000

SELECT distinct comptype.ctpdescription, STDDEV(distances.cdsdistance) over (PARTITION BY comptype.ctpdescription)
FROM 
	 tbllbcompetitions competitions,
     tbllbcompdistances distances,
     tblcomptype comptype  
WHERE distances.cdscompetitionid = competitions.cmpid 
AND competitions.cmpcompetitiontype = comptype.ctpid

