var login = new XMLHttpRequest();

login.open('POST','' , true);

login.onreadystatechange() = function(){
    if(this.readyState == 4 && this.status == 200){	
        let response = this.responseText;
        alert(response);
    }
}

var getLogins = () => login.send();