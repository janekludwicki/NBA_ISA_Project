import { Component, OnInit} from '@angular/core';
import {Teams} from "../../model/teams";
import {Team} from "../../model/team";
import {TeamService} from "../../service/team.service";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-team-list',
  templateUrl: './team-list.component.html',
  styleUrl: './team-list.component.css'
})
export class TeamListComponent implements OnInit{
  constructor(private teamService: TeamService,
  private route: ActivatedRoute,
  private router: Router) {}

  teams: Teams | undefined;

  ngOnInit() {
    this.teamService.getTeams().subscribe(teams=>this.teams= teams)
  }

  onDelete(team:Team) {
    this.teamService.deleteTeam(team.id).subscribe(()=>this.ngOnInit());
  }

}
