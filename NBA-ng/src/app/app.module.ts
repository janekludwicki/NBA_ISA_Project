import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MainComponent} from "./components/main/main.component";
import {NavComponent} from "./components/nav/nav.component";
import {HeaderComponent} from "./components/header/header.component";
import {FooterComponent} from "./components/footer/footer.component";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {TeamListComponent} from "./team/view/team-list/team-list.component";
import {TeamViewComponent} from "./team/view/team-view/team-view.component";
import {PlayerListComponent} from "./player/view/player-list/player-list.component";
import {PlayerViewComponent} from "./player/view/player-view/player-view.component";
import {TeamEditComponent} from "./team/view/team-edit/team-edit.component";
import {TeamCreateComponent} from "./team/view/team-create/team-create.component";
import {PlayerCreateComponent} from "./player/view/player-create/player-create.component";
import {PlayerEditComponent} from "./player/view/player-edit/player-edit.component";
@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    NavComponent,
    HeaderComponent,
    FooterComponent,
    TeamViewComponent,
    TeamListComponent,
    TeamCreateComponent,
    //TeamEditComponent,
    PlayerViewComponent,
    PlayerListComponent,
    PlayerEditComponent,
    PlayerCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
