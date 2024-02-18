import {Component, OnInit} from '@angular/core';
import {Models} from "../../../Model/Entity/Models";
import {ModelService} from "../../../Model/Service/model.service";
import {Model} from "../../../Model/Entity/Model";
import {Ship} from "../../Entity/Ship";
import {Ships} from "../../Entity/Ships";
import {ShipService} from "../../Service/ship-service/ShipService";

@Component({
  selector: 'app-ships-list',
  templateUrl: './ships-list.component.html',
  styleUrl: './ships-list.component.css'
})
export class ShipsListComponent implements OnInit{

  ships: Ships | undefined;

  constructor(private service: ShipService) {

  }

  ngOnInit() {
    this.service.getShips().subscribe(ships => {
      return this.ships = ships;
    });
  }

  onDelete(ship: Ship): void {
    this.service.deleteShip(ship.id).subscribe(() => this.ngOnInit());
  }
}
