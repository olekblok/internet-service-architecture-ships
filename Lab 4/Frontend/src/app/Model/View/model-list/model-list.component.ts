import {Component, OnInit} from '@angular/core';
import {ModelService} from "../../Service/model.service";
import {Models} from "../../Entity/Models";
import {Model} from "../../Entity/Model";

@Component({
  selector: 'app-model-list',
  templateUrl: './model-list.component.html',
  styleUrl: './model-list.component.css'
})
export class ModelListComponent implements OnInit{

  models: Models | undefined;

  constructor(private service: ModelService) {

  }

  ngOnInit() {
    this.service.getModels().subscribe(models => {
      return this.models = models;
    });
  }

  onDelete(model: Model): void {
    this.service.deleteModel(model.id).subscribe(() => this.ngOnInit());
  }
}
