// model-add.component.ts
import {Component, OnInit} from '@angular/core';
import {ModelService} from "../../Service/model.service";
import {Router} from '@angular/router';
import {ModelForm} from "../../Entity/ModelForm";

@Component({
  selector: 'app-model-add',
  templateUrl: './model-add.component.html',
  styleUrls: ['./model-add.component.css']
})
export class ModelAddComponent implements OnInit {

  model: ModelForm = {
    name: '',
    length_of_ship: 0
  };

  constructor(
    private modelService: ModelService,
    private router: Router
  ) {
  }

  ngOnInit() {
  }

  onSubmit(): void {
    this.modelService.postModel(this.model)
      .subscribe(() => this.router.navigate(['/models']));
  }

}
