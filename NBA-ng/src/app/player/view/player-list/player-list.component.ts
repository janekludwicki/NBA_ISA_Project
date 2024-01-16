import { Component, OnInit } from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {Players} from "../../model/players";
import {Player} from "../../model/player";

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html',
  styleUrl: './player-list.component.css'
})
export class PlayerListComponent implements OnInit{

  constructor(private playerService: PlayerService) {}

  players: Players |undefined;

  ngOnInit() {
    this.playerService.getPlayers().subscribe(players=>(this.players = players));
  }

  onDelete(player:Player) {
    this.playerService.deletePlayer(player.id).subscribe(()=>{this.ngOnInit()});
  }
}
