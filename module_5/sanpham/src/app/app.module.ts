import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CreateComponent} from './create/create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { DeleteComponent } from './delete/delete.component';
import { EditComponent } from './edit/edit.component';
import { ListComponent } from './list/list.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateComponent,
    DeleteComponent,
    EditComponent,
    ListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
