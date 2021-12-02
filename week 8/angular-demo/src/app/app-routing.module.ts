import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { DirectivesComponent } from './components/directives/directives.component';
import { HomeComponent } from './components/home/home.component';
import { PokehomeComponent } from './components/pokehome/pokehome.component';
import { PokemonComponent } from './components/pokemon/pokemon.component';
import { TtaalComponent } from './components/ttaal/ttaal.component';

const routes: Routes = [{
  path: '',
  component: HomeComponent
}, {
  path: 'ttaal',
  component: TtaalComponent
}, {
  path: 'databinding',
  component: DatabindingComponent
}, {
  path: 'directives',
  component: DirectivesComponent
}, {
  path: 'pokemon',
  component: PokehomeComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
