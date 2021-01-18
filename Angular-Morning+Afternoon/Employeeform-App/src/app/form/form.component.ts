import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import {  FormControl,FormGroup, FormBuilder, Validators} from "@angular/forms";
import { DatasetService } from '../dataset.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {


  constructor(private fb : FormBuilder,private dataset: DatasetService) { }

  userform = this.fb.group({
    Fname : ['',Validators.required],
    Lname : ['',Validators.required],
    age : ['', [Validators.required,Validators.min(1),Validators.max(60)]],
    city : [''],
    Empid : ['',Validators.required]
  });


  @Output()
  Emitevent = new EventEmitter<string>();

  @Output()
  ToggleEvent = new EventEmitter<string>();

  ngOnInit(): void {
  }
  toggleinner()
  {
    this.ToggleEvent.emit("123");
  }

  insert(){
    this.userform.reset();

    this.userform.get("Empid").enable();
  }
  edit(item)
  {
    this.userform.setValue(item);
    this.userform.get("Empid").disable();
  }
  onSubmit()
  {
    this.userform.get("Empid").enable();
    let key = this.userform.value.Empid;
    console.log(key);
    this.dataset.additem(key,this.userform.value);
    this.Emitevent.emit('load');
  }
}
