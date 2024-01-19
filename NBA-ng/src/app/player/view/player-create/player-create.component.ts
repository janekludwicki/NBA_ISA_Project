import { Component, OnInit } from '@angular/core';
import {PlayerForm} from "../../model/player-form";
import {PlayerService} from "../../service/player.service";
import {ActivatedRoute, Route, Router} from "@angular/router";

@Component({
  selector: 'app-player-create',
  templateUrl: './player-create.component.html',
  styleUrl: './player-create.component.css'
})
export class PlayerCreateComponent implements OnInit{

  id:string |undefined;
  player: PlayerForm = {id: "", name:'', surname:'', yearOfBirth:0, height:15, jerseyNo:69, position:'', teamID:''}

  constructor( private playerService: PlayerService,
               private route:ActivatedRoute,
               private router:Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params=>{this.player.teamID=params['id']});
  }

  onSubmit():void{
    this.playerService.putPlayer(this.player.id!, this.player!)
      .subscribe(()=>this.router.navigate([`teams/${this.player.teamID}`]));
  }
}
