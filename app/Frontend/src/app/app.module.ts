import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ModelListComponent} from "./Model/View/model-list/model-list.component";
import { ModelService} from "./Model/Service/model.service";
import {ModelDetailsComponent} from "./Model/View/model-details/model-details.component";
import {ShipsListComponent} from "./Ship/View/ships-list/ships-list.component";
import {ShipDetailsComponent} from "./Ship/View/ship-details/ship-details.component";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import {ShipService} from "./Ship/Service/ship-service/ShipService";
import {ShipAddComponent} from "./Ship/View/ship-add/ship-add.component";
import {ModelAddComponent} from "./Model/View/model-add/model-add.component";
import {ModelEditComponent} from "./Model/View/model-edit/model-edit.component";
import {ShipEditComponent} from "./Ship/View/ship-edit/ship-edit.component";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    ModelListComponent,
    ModelDetailsComponent,
    ModelAddComponent,
    ModelEditComponent,
    ShipsListComponent,
    ShipDetailsComponent,
    ShipAddComponent,
    ShipEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    ModelService,
    ShipService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
