import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {Models} from "../../../Model/Entity/Models";
import {ShipForm} from "../../Entity/ShipForm";
import {ShipService} from "../../Service/ship-service/ShipService";
import {ModelService} from "../../../Model/Service/model.service";
import {ShipEdit} from "../../Entity/ShipEdit";

@Component({
  selector: 'app-ship-edit',
  templateUrl: './ship-edit.component.html',
  styleUrls: ['./ship-edit.component.css']
})
export class ShipEditComponent implements OnInit {

  uuid: string | undefined;

  ship: ShipEdit | undefined;

  original: ShipEdit | undefined;

  models: Models | undefined;

  constructor(
    private shipService: ShipService,
    private modelService: ModelService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.modelService.getModels()
        .subscribe(models => this.models = models);

      this.shipService.getShip(params['uuid'])
        .subscribe(ship => {
          this.uuid = ship.id;
          this.ship = {
            name: ship.name,
            cost: ship.cost,
          };
          this.original = {...this.ship};
        });
    });
  }

  onSubmit(): void {
    this.shipService.putShip(this.uuid!, this.ship!)
      .subscribe(() => this.router.navigate(['/ships']));
  }

}
