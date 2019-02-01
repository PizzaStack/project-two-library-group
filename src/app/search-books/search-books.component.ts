import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import {AuthenticationService } from '../_services/authentication.service';

@Component({
  selector: 'app-search-books',
  templateUrl: './search-books.component.html',
  styleUrls: ['./search-books.component.css']
})
export class SearchBooksComponent implements OnInit {
  searchForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  bookInfo: any;
  

  constructor(
    private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {
    this.searchForm = this.formBuilder.group({
      searchBooks: ['', Validators.required]
  });
  
    
  }
  get f() { return this.searchForm.controls; }

  onSubmitb() {

    // this.submitted = false;

    // stop here if form is invalid
    if (this.searchForm.invalid) {
        return;
    }
  
        this.loading = true;
        this.authenticationService.search(this.f.searchBooks.value)
            .pipe(first())
            .subscribe(
                data => {
                     this.bookInfo = (data);
                     console.log(this.bookInfo.title);
                    this.router.navigate(['showBook']);
                    if(this.loading)
                    window.location.reload();
                },
                error => {
                    //this.alertService.error(error);
                    this.loading = false;
                });
            }

            searchbook(entry): void {
                this.searchbook = entry;
            }

            onSubmita() {

                // this.submitted = false;
            
                // stop here if form is invalid
                if (this.searchForm.invalid) {
                    return;
                }
              
                    this.loading = true;
                    this.authenticationService.author(this.f.searchBooks.value)
                        .pipe(first())
                        .subscribe(
                            data => {
                                 this.bookInfo = (data);
                                 console.log(this.bookInfo.title);
                                this.router.navigate(['showBook']);
                                
                                window.location.reload();
                            },
                            error => {
                                //this.alertService.error(error);
                                this.loading = false;
                            });
                        }
            
}
