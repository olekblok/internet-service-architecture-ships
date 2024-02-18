import {Component, OnInit} from '@angular/core';
import {ShipService} from "../../Service/ship-service/ShipService";
import {ActivatedRoute, Router} from '@angular/router';
import {ShipForm} from "../../Entity/ShipForm";
import {ModelService} from "../../../Model/Service/model.service";
import {Models} from "../../../Model/Entity/Models";

@Component({
  selector: 'app-ship-add',
  templateUrl: './ship-add.component.html',
  styleUrls: ['./ship-add.component.css']
})
export class ShipAddComponent implements OnInit {

  ship: ShipForm = {
    model_id:'',
    name: '',
    cost: 0
  };

  constructor(
    private shipService: ShipService,
    private modelService: ModelService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params =>{
    this.modelService.getModel(params['uuid'])
      .subscribe(model => {
        this.ship.model_id = model.id;
      })
    })
  }

  onSubmit(): void {
    this.shipService.postShip(this.ship.model_id, this.ship)
      .subscribe(() => this.router.navigate([`/ships//${this.ship.model_id}`]));
  }

}


