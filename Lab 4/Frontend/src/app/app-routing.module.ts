import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ModelListComponent} from "./Model/View/model-list/model-list.component";
import {ModelDetailsComponent} from "./Model/View/model-details/model-details.component";
import {ShipsListComponent} from "./Ship/View/ships-list/ships-list.component";
import {ShipDetailsComponent} from "./Ship/View/ship-details/ship-details.component";
import {ShipAddComponent} from "./Ship/View/ship-add/ship-add.component";
import {ModelAddComponent} from "./Model/View/model-add/model-add.component";
import {ModelEditComponent} from "./Model/View/model-edit/model-edit.component";
import {ShipEditComponent} from "./Ship/View/ship-edit/ship-edit.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: ModelListComponent,
    path: "models"
  },
  {
    component: ModelAddComponent,
    path: "models/add"
  },
  {
    component: ModelDetailsComponent,
    path:"models/:uuid"
  },
  {
    component: ShipAddComponent,
    path:"models/:uuid/ship"
  },
  {
    component:ModelEditComponent,
    path: "models/:uuid/edit"
  },
  {
    component: ShipsListComponent,
    path:"ships"
  },
  {
    component:ShipDetailsComponent,
    path:"ships/:uuid"
  },
  {
    component:ShipEditComponent,
    path: "ships/:uuid/edit"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
