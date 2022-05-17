import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListComponent} from './list/list.component';
import {EditComponent} from './edit/edit.component';
import {CreateComponent} from './create/create.component';
import {DeleteComponent} from './delete/delete.component';


const routes: Routes = [
  {path: '', component: ListComponent},
  {path: 'edit', component: EditComponent},
  {path: 'create', component: CreateComponent},
  {path: 'delete', component: DeleteComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
