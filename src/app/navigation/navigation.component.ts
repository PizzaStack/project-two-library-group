import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],

  <mwl-text-input-autocomplete-container>
      <textarea
        placeholder="Type @ to search..."
        class="form-control"
        rows="5"
        [(ngModel)]="formControlValue"
        mwlTextInputAutocomplete
        [findChoices]="findChoices"
        [getChoiceLabel]="getChoiceLabel">
      </textarea>
    </mwl-text-input-autocomplete-container>
})
export class NavigationComponent implements OnInit {

  
  constructor() { }

  ngOnInit() {
  }

}
