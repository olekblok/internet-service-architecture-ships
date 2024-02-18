import { Component, OnInit } from '@angular/core';
import {ShipService} from "../../Service/ship-service/ShipService";
import { ActivatedRoute, Router } from "@angular/router";
import {ShipsDetails} from "../../Entity/ShipsDetails";

@Component({
  selector: 'app-ship-details',
  templateUrl: './ship-details.component.html',
  styleUrls: ['./ship-details.component.css']
})
export class ShipDetailsComponent implements OnInit {

  ship: ShipsDetails | undefined;

  constructor(private service: ShipService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getShip(params['uuid'])
        .subscribe(ship => this.ship = ship)
    });
  }

}
