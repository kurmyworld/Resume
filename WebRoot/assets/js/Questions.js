function loadAllQuestions(method,url,element)
{
  xmlhttp = new XMLHttpRequest();
  xmlhttp.open(method,url,false);
  xmlhttp.send();
//alert(xmlhttp.responseText);
  element.innerHTML=xmlhttp.responseText;
  
}
