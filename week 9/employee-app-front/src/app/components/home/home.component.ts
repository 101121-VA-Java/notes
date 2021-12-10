import { Component, OnInit } from '@angular/core';
import { Principal } from 'src/app/models/principal';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private authService: AuthService) { }

  currentUser?: Principal;

  ngOnInit(): void {
    this.currentUser = this.authService.currentUser;
  }

}
