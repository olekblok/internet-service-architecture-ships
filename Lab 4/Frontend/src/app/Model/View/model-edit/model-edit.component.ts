import { Component, OnInit } from '@angular/core';
import {ModelService} from "../../Service/model.service";
import { ActivatedRoute, Router } from '@angular/router';
import {ModelForm} from "../../Entity/ModelForm";
import {Models} from "../../Entity/Models";

@Component({
  selector: 'app-model-edit',
  templateUrl: './model-edit.component.html',
  styleUrls: ['./model-edit.component.css']
})
export class ModelEditComponent implements OnInit {

  uuid: string | undefined;

  model: ModelForm | undefined;

  original: ModelForm | undefined;

  models: Models | undefined;

  constructor(
    private modelService: ModelService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {

      this.modelService.getModel(params['uuid'])
        .subscribe(model => {
          this.uuid = model.id;
          this.model = {
            name: model.name,
            length_of_ship: model.length_of_ship
          };
          this.original = {...this.model};
        });
    });
  }

  onSubmit(): void {
    this.modelService.putModel(this.uuid!, this.model!)
      .subscribe(() => this.router.navigate(['/models', this.uuid]));
  }

}
