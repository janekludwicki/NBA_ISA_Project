import { Component, OnInit } from '@angular/core';
import {TeamDetails} from "../../model/team-details";
import {TeamService} from "../../service/team.service";
import {PlayerService} from "../../../player/service/player.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-team-view',
  templateUrl: './team-view.component.html',
  styleUrl: './team-view.component.css'
})
export class TeamViewComponent implements OnInit{
    team: TeamDetails | undefined;

  constructor(
      private teamService: TeamService,
      private playerService: PlayerService,
      private route: ActivatedRoute,
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params)=>{
      this.teamService
          .getTeam(params['uuid'])
          .subscribe((team)=>{
            this.team = team;
            this.playerService
                .getPlayersByTeam(params['uuid'])
                .subscribe((players)=>{
                  if(this.team!=undefined){
                    this.team.players = players.players;
                  }
                })
          })
    })
  }

  deletePlayer(uuid:string){
    this.playerService.deletePlayer(uuid).subscribe(()=>{this.ngOnInit()})
  }
}

