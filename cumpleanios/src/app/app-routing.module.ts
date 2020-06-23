import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SaludosCumpleaniosComponent } from './pages/saludos-cumpleanios/saludos-cumpleanios.component';

const routes: Routes = [
  {path:'saludos-cumpleanios', component:SaludosCumpleaniosComponent},
  {path:'**', pathMatch:'full', redirectTo:'saludos-cumpleanios'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
