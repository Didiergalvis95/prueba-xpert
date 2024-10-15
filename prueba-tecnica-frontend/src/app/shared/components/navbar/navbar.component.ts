import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  constructor(private router: Router, private authService: AuthService) {}

  isLoginPage(): boolean {
    return this.router.url === '/login' || this.router.url === '/register';
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
