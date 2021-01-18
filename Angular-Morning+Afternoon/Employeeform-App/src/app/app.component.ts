import { Component, OnInit, OnChanges, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms'
import { Router, RouterModule } from '@angular/router';
import { DatasetService } from './dataset.service';
import { FormComponent } from './form/form.component';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})



export class AppComponent implements OnInit{

  title = 'Employeeform-App';
  tabledata;
  displayForm:boolean = false;
  constructor(private dataset : DatasetService ){}

  emitdatahandler(str){

    this.ngOnInit();

    this.toggle();
  }
  @ViewChild(FormComponent) child:FormComponent;
  edit(item)
  {
    this.toggle();
    this.child.edit(item);
  }

  insert()
  {
    this.toggle();
    this.child.insert();
  }

  toggle(str?)
  {
    this.displayForm = ! this.displayForm;
    console.log(this.displayForm);
  }

  delete(str)
  {

    this.dataset.removeitem(str);
    this.ngOnInit();
  }
  ngOnInit()
  {
    this.tabledata = this.dataset.getAllitem();
    console.log(this.tabledata);
  }
}
