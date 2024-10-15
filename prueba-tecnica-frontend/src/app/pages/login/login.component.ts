import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from 'src/app/core/models/interfaces/login';
import { AuthService } from 'src/app/core/services/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  
  username: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  ngOnInit() {
    if (this.authService.isAuthenticated()) {
      this.router.navigate(['/']);
    }
  }

  onSubmit() {
    const login: Login ={
      username: this.username,
      password: this.password
    }
    this.authService.login(login).subscribe({
      next: (data: any) => {        
        this.authService.storeToken(data.jwt);
        this.router.navigate(['/']);

      },
      error: (error) => {
        Swal.fire({
          title: 'Error al iniciar sesión',
          text: 'Usuario o contraseña incorrectos',
          icon: 'error',
          confirmButtonText: 'Aceptar'
        })
      }
    });      
  }

}
