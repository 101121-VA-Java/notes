import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TtaalComponent } from './components/ttaal/ttaal.component';

const routes: Routes = [{
  path: '',
  component: HomeComponent
}, {
  path: 'ttaal',
  component: TtaalComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
