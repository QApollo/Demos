# OCA Demo

## Chapter 3
In chapter 3 I have learned a lot about date/time, differences between Array's and ArrayLists and equality. In this small demo I'll present a small application that will highlight them all.

### Date/Time
```
LocalDateTime datetime = LocalDateTime.now();
System.out.println("Time in chosen country: "+ datetime);

//To add time 
System.out.println("Time in chosen country: "+ datetime.plusHours(7));
```
### Array/Lists
```
String[] countries = {
        "Amsterdam",
        "Berlin",
        "Hongkong",
        "Tokyo"
    };
```
### Equality
```
 if (input.toLowerCase().matches("0|1|2|3")) {
 	...
 }
```