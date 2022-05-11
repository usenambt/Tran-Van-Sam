import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import { PetInforComponent } from './pet-infor/pet-infor.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ListCategoryComponent } from './list-category/list-category.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';
import { DetailsHackernewsComponent } from './details-hackernews/details-hackernews.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';
import { LoginComponent } from './login/login.component';
import { RegisterFinalComponent } from './register-final/register-final.component';
import { TodoComponent } from './todo/todo.component';
import { AloComponent } from './alo/alo.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetInforComponent,
    ListCategoryComponent,
    CalculatorComponent,
    ColorPickerComponent,
    DetailsHackernewsComponent,
    FooterComponent,
    NavbarComponent,
    RatingBarComponent,
    CountdownTimerComponent,
    LoginComponent,
    RegisterFinalComponent,
    TodoComponent,
    AloComponent,
      ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
