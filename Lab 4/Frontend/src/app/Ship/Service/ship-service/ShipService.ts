import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Ships} from "../../Entity/Ships";
import {ShipsDetails} from "../../Entity/ShipsDetails";
import {ShipForm} from "../../Entity/ShipForm";
import {ShipEdit} from "../../Entity/ShipEdit";

@Injectable()
export class ShipService {

  constructor(private http: HttpClient) {

  }

  getShips(): Observable<Ships> {
    return this.http.get<Ships>('/api/ships');
  }

  getShip(uuid: string): Observable<ShipsDetails> {
    return this.http.get<ShipsDetails>('/api/ships/' + uuid);
  }

  deleteShip(uuid: string): Observable<any> {
    return this.http.delete('/api/ships/' + uuid);
  }

  postShip(uuid: string | undefined, request: ShipForm): Observable<any> {
    return this.http.post('/api/ships?modelID=' + uuid, request);
  }

  putShip(uuid: string, request: ShipEdit): Observable<any> {
    return this.http.put('/api/ships/' + uuid, request);
  }

}
