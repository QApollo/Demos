//to fetch all the xml data
function getXMLData() {
     var xReq = new XMLHttpRequest();
     xReq.open("GET", "./xml/books.xml",false);
     xReq.send(null);
     $("#otherCommentsText").text(xReq.response);
}

//to erase data
function eraseText() {
    document.getElementById("otherCommentsText").value = "";
    window.location.reload();
}

//to get book details by tag name
function getBookByTagName() {
      var xReq = new XMLHttpRequest();
      xReq.open("GET", "./xml/books.xml",false);
      xReq.send(null);

      var x, i, xmlDoc, txt;
      xmlDoc = xReq.responseXML;
      txt = "";

      //to get tag value form UI
      var tagval = document.getElementById("GetElementByTagNameText").value;
      x = xmlDoc.getElementsByTagName(tagval);
      for (i = 0; i< x.length; i++) {
        txt += x[i].childNodes[0].nodeValue + "<br>";
      }
      document.getElementById("getResult").innerHTML = txt;
}


//to get book by xpath
function getBookByXpath() {
       var xReq = new XMLHttpRequest();
       xReq.open("GET", "./xml/books.xml",false);
       xReq.send(null);

       var txt = "";

       //to get xpath value form UI
       var tagval = document.getElementById("GetElementByXpathText").value;
       path = tagval
       xmlDoc = xReq.responseXML;

        if (xmlDoc.evaluate) {
               var nodes = xmlDoc.evaluate(path, xmlDoc, null, XPathResult.ANY_TYPE, null);
               var result = nodes.iterateNext();
               while (result) {
                   txt += result.childNodes[0].nodeValue + "<br>";
                   result = nodes.iterateNext();
               }
        }
       document.getElementById("getResult").innerHTML = txt;
 }


// to get the valid author code (valid case = 'dddd ss' (here, d == number and s == string)
function getValidAuthorCode() {
      var xReq = new XMLHttpRequest();
      xReq.open("GET", "./xml/books.xml",false);
      xReq.send(null);

      var regExpression = /^\d\d\d\d[\s{1}]?[A-Z,a-z]/;
      var x, i, xmlDoc, txt;
      xmlDoc = xReq.responseXML;
      txt = "";

      //to get tag value form UI
      var tagval = "authorCode";
      x = xmlDoc.getElementsByTagName(tagval);
      for (i = 0; i< x.length; i++) {
         if(regExpression.test(x[i].childNodes[0].nodeValue)){
             txt += x[i].childNodes[0].nodeValue + "<br>";
	}        
      }
      document.getElementById("getResult").innerHTML = txt;
}


// to get the invalid author code (valid case = 'dddd ss' (here, d == number and s == string)
function getInValidAuthorCode() {
      var xReq = new XMLHttpRequest();
      xReq.open("GET", "./xml/books.xml",false);
      xReq.send(null);

      var regExpression = /^\d\d\d\d[\s{1}]?[A-Z,a-z]/;
      var x, i, xmlDoc, txt;
      xmlDoc = xReq.responseXML;
      txt = "";

      //to get tag value form UI
      var tagval = "authorCode";
      x = xmlDoc.getElementsByTagName(tagval);
      for (i = 0; i< x.length; i++) {
         if(!regExpression.test(x[i].childNodes[0].nodeValue)){
             txt += x[i].childNodes[0].nodeValue + "<br>";
	}        
      }
      document.getElementById("getResult").innerHTML = txt;
}