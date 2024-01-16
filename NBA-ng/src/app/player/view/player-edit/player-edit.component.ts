import { Component, OnInit } from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerForm} from "../../model/player-form";
@Component({
  selector: 'app-player-edit',
  templateUrl: './player-edit.component.html',
  standalone: true,
  styleUrl: './player-edit.component.css'
})
export class PlayerEditComponent /*implements OnInit*/{
  uuid: string | undefined;
  player:PlayerForm | undefined;
  original:PlayerForm | undefined;

  constructor(private playerService:PlayerService,
              private route:ActivatedRoute,
              private router:Router) {
  }

}
