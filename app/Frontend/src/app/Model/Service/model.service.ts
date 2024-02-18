import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {map, mergeMap, Observable} from "rxjs";
import { Models } from "../Entity/Models";
import { Model} from "../Entity/Model";
import {ModelDetails} from "../Entity/ModelDetails";
import {ModelForm} from "../Entity/ModelForm";
import {Ships} from "../../Ship/Entity/Ships";

@Injectable({
  providedIn: 'root'
})
export class ModelService {

  constructor(private http: HttpClient) {

  }

  getModels(): Observable<Models> {
    return this.http.get<Models>('api/models');
  }

  getModel(uuid: string): Observable<ModelDetails> {
    return this.http.get<ModelDetails>('/api/models/' + uuid).pipe(
      mergeMap((model: ModelDetails) => {
        return this.http.get<Ships>('/api/ships', {params: {model_id: uuid}}).pipe(
          map((ships: Ships) => {
            model.ships = ships;
            return model;
          })
        );
      })
    );
  }

  deleteModel(uuid: string): Observable<any> {
    return this.http.delete('api/models/' + uuid);
  }

  putModel(uuid: string, request: ModelForm): Observable<any> {
    return this.http.put('api/models/' + uuid, request);
  }

  postModel(request: ModelForm): Observable<any> {
    return this.http.post('api/models', request);
  }

}
