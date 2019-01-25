import { Component, OnInit, Input } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  Username;
  formdata;
  constructor(private router: Router) { }
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
@Input() public isUserLoggedIn: boolean;

public onLoginClick(){
  this.router.navigate(['./patron']);
}
  }



