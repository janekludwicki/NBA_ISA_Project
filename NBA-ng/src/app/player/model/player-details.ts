import {Team} from "../../team/model/team"

export interface PlayerDetails{

  id:string;
  name:string;
  surname:string;
  yearOfBirth:number;
  jerseyNo:number;
  height:number;
  position:string;
  team:Team;
}
