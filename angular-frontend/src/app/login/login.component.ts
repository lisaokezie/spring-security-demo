import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthorizationService } from '../services/authorization.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  message: string;

  validLogin: boolean;

  constructor(private authorizationService: AuthorizationService, private router: Router) { }

  ngOnInit(): void {
  }

  login(){
    this.authorizationService.authenticate(this.username, this.password).subscribe(() => {
      this.validLogin = true;
      this.router.navigate(['employees']);
    },
    error => {
      this.validLogin = false
    });
  }
}
