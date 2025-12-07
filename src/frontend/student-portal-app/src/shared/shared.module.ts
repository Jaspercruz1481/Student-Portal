import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {NzLayoutModule} from 'ng-zorro-antd/layout';
import {NzMenuModule} from 'ng-zorro-antd/menu';
import {NzButtonModule} from 'ng-zorro-antd/button';
import {NzIconModule} from 'ng-zorro-antd/icon';
import {NzCardModule} from 'ng-zorro-antd/card';
import {NzListModule} from 'ng-zorro-antd/list';
import {NzGridModule} from 'ng-zorro-antd/grid';
import {NzTableModule} from "ng-zorro-antd/table";


@NgModule({
  imports: [
    CommonModule,
    FormsModule,

    // NG-ZORRO Imports
    NzLayoutModule,
    NzMenuModule,
    NzButtonModule,
    NzIconModule,
    NzCardModule,
    NzListModule,
    NzGridModule,
    NzTableModule,
  ],
  exports: [
    CommonModule,
    FormsModule,

    // Re-export so ALL modules inherit these
    NzLayoutModule,
    NzMenuModule,
    NzButtonModule,
    NzIconModule,
    NzCardModule,
    NzListModule,
    NzGridModule,
    NzTableModule,
  ]
})
export class SharedModule { }
