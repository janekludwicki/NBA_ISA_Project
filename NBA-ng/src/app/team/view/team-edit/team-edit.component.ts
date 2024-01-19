import { Component, OnInit } from '@angular/core';
import {TeamForm} from "../../model/team-form";
import {Players} from "../../../player/model/players";
import {TeamService} from "../../service/team.service";
import {PlayerService} from "../../../player/service/player.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-team-edit',
  templateUrl: './team-edit.component.html',
  styleUrl: './team-edit.component.css'
})
export class TeamEditComponent implements OnInit {
  uuid:string |undefined;
  team: TeamForm | undefined;
  originalTeam : TeamForm | undefined;
  players: Players | undefined

  constructor(private teamService : TeamService,
              private playerService :PlayerService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params =>{
      this.playerService.getPlayers()
          .subscribe(players =>{this.players = players});

      this.teamService.getTeam(params['uuid'])
          .subscribe(team =>{
            this.uuid = team.id;
            this.team = {
              id: team.id,
              name: team.name,
              city: team.city,
              coach: team.coach,
              noOfChampionships: team.noOfChampionships
            }
            this.originalTeam = {...this.team};
          });
    });
  }
  onSubmit():void{
    this.teamService.putTeam(this.uuid!, this.team!)
        .subscribe(
            ()=>
                this
                    .router
                    .navigate(['/shops']))
  }
}
