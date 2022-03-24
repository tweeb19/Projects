import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { KidsComponent } from './pages/movie-selections/kids/kids.component';
import { NowInTheatersComponent } from './pages/movie-selections/now-in-theaters/now-in-theaters.component';
import { RatedRComponent } from './pages/movie-selections/rated-r/rated-r.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { RegisterComponent } from './pages/register/register.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'kids-movies', component: KidsComponent},
  {path: 'now-in-theaters', component: NowInTheatersComponent},
  {path: 'rated-r', component: RatedRComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [LoginComponent, ProfileComponent, 
RegisterComponent, KidsComponent, NowInTheatersComponent, RatedRComponent]