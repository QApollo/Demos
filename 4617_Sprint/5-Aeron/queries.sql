select comptype.ctpdescription, avg(distances.cdsdistance)
from 
	 tbllbcompetitions competitions,
     tbllbcompdistances distances,
     tblcomptype comptype  
where distances.cdscompetitionid = competitions.cmpid 
and competitions.cmpcompetitiontype = comptype.ctpid
group by comptype.ctpdescription

select *
from 
	 tbllbcompetitions competitions,
     tbllbcompdistances distances,
     tblcomptype comptype  
where distances.cdscompetitionid = competitions.cmpid 
and competitions.cmpcompetitiontype = comptype.ctpid
and comptype.ctpdescription = 'NK Allround'

select distinct persons.prsfirstname || ' ' || persons.prslastname as fullname
from 
	 tbllbcompetitions competitions,
     tbllbcompetitors competitors,
     tblpersons persons,
     tbllbcompdistances distances,
     tblcomptype comptype 
where competitions.cmpid = competitors.cptcompetitionid 
and competitors.cptpersonid = persons.prsid   
and distances.cdscompetitionid = competitions.cmpid 
and competitions.cmpcompetitiontype = comptype.ctpid
and comptype.ctpdescription = 'NK Allround'

select distinct persons.prsfirstname || ' ' || persons.prslastname as fullname, persons.prsbirthdate
from 
	 tbllbcompetitions competitions,
     tbllbcompetitors competitors,
     tblpersons persons,
     tbllbcompdistances distances,
     tblcomptype comptype 
where competitions.cmpid = competitors.cptcompetitionid 
and competitors.cptpersonid = persons.prsid   
and distances.cdscompetitionid = competitions.cmpid 
and competitions.cmpcompetitiontype = comptype.ctpid
and comptype.ctpdescription = 'NK Allround'
and persons.prsbirthdate > 19000000
order by persons.prsbirthdate

select to_date(prsbirthdate::text, 'YYYYMMDD')
from 
	 tbllbcompetitions competitions,
     tbllbcompetitors competitors,
     tblpersons persons,
     tbllbcompdistances distances,
     tblcomptype comptype 
where competitions.cmpid = competitors.cptcompetitionid 
and competitors.cptpersonid = persons.prsid   
and distances.cdscompetitionid = competitions.cmpid 
and competitions.cmpcompetitiontype = comptype.ctpid
and comptype.ctpdescription = 'NK Allround'
and persons.prsbirthdate > 19000000

select distinct comptype.ctpdescription, STDDEV(distances.cdsdistance) over (partition by comptype.ctpdescription)
from 
	 tbllbcompetitions competitions,
     tbllbcompdistances distances,
     tblcomptype comptype  
where distances.cdscompetitionid = competitions.cmpid 
and competitions.cmpcompetitiontype = comptype.ctpid

