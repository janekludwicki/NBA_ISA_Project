import {Team} from "../../team/model/team"

export interface PlayerDetails{

  id:string;
  name:string;
  surname:string;
  yearOfBirth:number;
  jerseyNo:number;
  Height:number;
  position:string;
  team:Team;
}
