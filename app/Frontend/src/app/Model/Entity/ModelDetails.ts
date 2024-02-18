import {Ships} from "../../Ship/Entity/Ships";

export interface ModelDetails {
  id: string,
  name: string;
  length_of_ship: number;
  ships: Ships;
}
