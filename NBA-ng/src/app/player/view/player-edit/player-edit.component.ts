import { Component, OnInit } from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerForm} from "../../model/player-form";

@Component({
  selector: 'app-player-edit',
  templateUrl: './player-edit.component.html',
  styleUrl: './player-edit.component.css'
})
export class PlayerEditComponent implements OnInit{
  uuid: string | undefined;
  player:PlayerForm | undefined;
  original:PlayerForm | undefined;

  constructor(private playerService:PlayerService,
              private route:ActivatedRoute,
              private router:Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params=>{
      this.playerService.getPlayer(params['uuid'])
          .subscribe(player=>{
            this.uuid = player.id;
            this.player = {
              id: player.id,
              name: player.name,
              surname: player.surname,
              yearOfBirth: player.yearOfBirth,
              jerseyNo: player.jerseyNo,
              height: player.height,
              position: player.position,
              teamID: params['teamID']
            }
            this.original = {...this.player};
          });
    });
  }
  onSubmit():void{
    this.playerService.putPlayer(this.uuid!, this.player!)
        .subscribe(
            ()=>this.router.navigate([`/teams/${this.player?.teamID}`])
        )
  }
}
