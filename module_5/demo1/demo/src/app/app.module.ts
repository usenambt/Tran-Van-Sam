import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FontSizeEditorComponent } from './font-size-editor/font-size-editor.component';
import { PetInforComponent } from './pet-infor/pet-infor.component';
import {FormsModule} from "@angular/forms";
import { ListCategoryComponent } from './list-category/list-category.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { ColorPickerComponent } from './color-picker/color-picker.component';
import { DetailsHackernewsComponent } from './details-hackernews/details-hackernews.component';
import { FooterComponent } from './footer/footer.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { CoutdownComponent } from './coutdown-timer/coutdown.component';

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
    CoutdownComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
