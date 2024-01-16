import { Component, OnInit } from '@angular/core';
import {TeamForm} from "../../model/team-form";
import {TeamService} from "../../service/team.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-team-create',
  templateUrl: './team-create.component.html',
  styleUrl: './team-create.component.css'
})
export class TeamCreateComponent /*implements OnInit*/{
  uuid:string | undefined;
  team: TeamForm = {id:'', name:'', city:'', coach:'', noOfChampionships:0}

  constructor(private teamService: TeamService,
              private router:Router,
              private route:ActivatedRoute) {}

  /*
  ngOnInit() {
    this.route.params.subscribe(params=>{this.team.id=params['id']});
  }
  */


  onSubmit(): void{
    this.teamService.putTeam(this.team.id, this.team!)
      .subscribe(()=>this.router.navigate(['/teams']))
  }
}
