	function checkSubmit(Element1,Element2){
		var p1 = document.getElementById(Element1);
		var p2 = document.getElementById(Element2);
		if(p1.value != p2.value){
			alert("两次输入的密码不同，请检查！");
			return false;
		}
		return true;
	}	
