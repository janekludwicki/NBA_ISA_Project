import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TeamListComponent} from "./team/view/team-list/team-list.component";
import {TeamViewComponent} from "./team/view/team-view/team-view.component";
import {PlayerListComponent} from "./player/view/player-list/player-list.component";
import {PlayerViewComponent} from "./player/view/player-view/player-view.component";
import {TeamEditComponent} from "./team/view/team-edit/team-edit.component";
import {TeamCreateComponent} from "./team/view/team-create/team-create.component";
import {PlayerCreateComponent} from "./player/view/player-create/player-create.component";
import {PlayerEditComponent} from "./player/view/player-edit/player-edit.component";

const routes: Routes = [
  {
    component: TeamListComponent,
    path: 'teams',
  },
  {
    component: TeamCreateComponent,
    path: 'teams/create'
  },
  {
    component: TeamViewComponent,
    path: 'teams/:uuid'
  },
  {
    component: PlayerListComponent,
    path: 'players',
  },
  {
    component: PlayerViewComponent,
    path: 'players/:uuid'
  },
  {
    component: TeamEditComponent,
    path: 'teams/:uuid/edit',
  },
  {
    component: PlayerCreateComponent,
    path: 'teams/:uuid/players/create'
  },
  {
    component: PlayerEditComponent,
    path: 'teams/:teamId/players/:uuid/edit'
  },
  {
    component: PlayerViewComponent,
    path: 'teams/:teamId/players/:uuid'
  }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
