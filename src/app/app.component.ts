 import { Component, Input, OnInit } from '@angular/core';
 import { FormControl, FormGroup, Validators } from '@angular/forms';
 import { Router } from '@angular/router';
 

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  title = 'Welcome Library Patrons';
  Username;
  password;
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
onClickSubmit(data) {
  if(this.Username == data.Username){
    console.log(this.Username + 'hello');
    this.router.navigate(['/', 'patron']);
  }else{
    this.router.navigate(['/', 'login']);
  }
}
@Input() public isUserLoggedIn: boolean;

public onLoginClick(){
  
  if(this.Username === "@jp"){
    console.log(this.Username + 'hello');
  this.router.navigate(['/', 'patron']);
  }else{
    console.log(this.Username);
    this.router.navigate(['/', 'login']);
  }
}
  }