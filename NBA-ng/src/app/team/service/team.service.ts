import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Teams} from "../model/teams";
import {TeamDetails} from "../model/team-details";
import {Team} from "../model/team";
import {TeamForm} from "../model/team-form";
import {HttpClient} from "@angular/common/http";
import {Players} from "../../player/model/players";

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient) { }

  getTeams(): Observable<Teams> {
    return this.http.get<Teams>('/api/teams');
  }

  deleteTeam(uuid: string): Observable<any> {
    return this.http.delete<Team>(`/api/teams/${uuid}`);
  }

  getTeam(uuid:string): Observable<TeamDetails> {
    return this.http.get<TeamDetails>(`/api/teams/${uuid}`);
  }

  putTeam(uuid:string, request:TeamForm):Observable<any>{
    return this.http.put(`/api/teams/${uuid}`, request);
  }
}
