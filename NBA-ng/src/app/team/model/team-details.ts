import {Player} from "../../player/model/player";

export interface TeamDetails{

  id:string;
  name:string;
  city:string;
  coach:string;
  noOfChampionships:number;
  players: Player[];
}
