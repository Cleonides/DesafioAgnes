import { Component } from '@angular/core';
import {RouterLinkActive, RouterOutlet} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: 'MenuComponent.html',
  standalone: true,
  imports: [FormsModule, CommonModule, RouterOutlet, RouterLinkActive, RouterModule],
  styleUrls: ['../assets/MenuComponent.css']
})
export class MenuComponent {
}

