import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  Username;
  formdata;
  constructor() { }
  title = 'Login';
  ngOnInit() {
    this.formdata = new FormGroup({
      Username: new FormControl("", Validators.compose([
        Validators.required,
        Validators.pattern("[^ @]*@[^ @]*")])),
      passwd: new FormControl("", this.passwordvalidation)
    });
   
}
passwordvalidation(formcontrol) {
  if (formcontrol.value.length < 5) {
     return {"passwd" : true};
  }
}
onClickSubmit(data) {this.Username = data.Username;}
  }



