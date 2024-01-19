import {ActivatedRoute} from "@angular/router";
import { Component, OnInit } from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {PlayerDetails} from "../../model/player-details";

@Component({
  selector: 'app-player-view',
  templateUrl: './player-view.component.html',
  styleUrl: './player-view.component.css'
})
export class PlayerViewComponent implements OnInit{

    player: PlayerDetails | undefined;

    constructor(
        private playerService: PlayerService,
        private route: ActivatedRoute,
    ) {}
  ngOnInit() {
      this.route.params.subscribe((params)=>{
        this.playerService.getPlayer(params['uuid'])
            .subscribe((player)=>(this.player = player))
      })
  }

  onDelete(uuid:string){
    this.playerService.deletePlayer(uuid).subscribe(()=>{this.ngOnInit()})
  }
}
