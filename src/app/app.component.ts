 import { Component, Input, OnInit } from '@angular/core';
 import { FormControl, FormGroup, Validators } from '@angular/forms';
 import { Router } from '@angular/router';
 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'The Revature Library';
  Username;
  formdata;
  constructor(private router: Router) { }

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