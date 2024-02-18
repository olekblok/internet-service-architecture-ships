import { Component, OnInit } from '@angular/core';
import {ModelService} from "../../Service/model.service";
import { ActivatedRoute, Router } from "@angular/router";
import {ModelDetails} from "../../Entity/ModelDetails";

@Component({
  selector: 'app-model-details',
  templateUrl: './model-details.component.html',
  styleUrls: ['./model-details.component.css']
})
export class ModelDetailsComponent implements OnInit {

  model: ModelDetails | undefined;
  uuid: string |undefined;

  constructor(private service: ModelService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getModel(params['uuid'])
        .subscribe(model => this.model = model)
    });
  }

}
