import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Register } from 'src/app/core/models/interfaces/register';
import { AuthService } from 'src/app/core/services/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  username: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    if (this.password === this.confirmPassword) {
      const register: Register = {
        username: this.username,
        email: this.email,
        password: this.password
      }
      this.authService.register(register).subscribe({
        next: (data) => {          
          if (data.message){
            Swal.fire({
              title: 'Registro exitoso!',
              text: 'Inicie Sesión para continuar',
              icon:'success',
            })
            setTimeout(() => {
              this.router.navigate(['/login']);
            }, 2000);
          }
        },
        error: (error) => {
          console.error('Error de registro:', error);
        }});
    }else {
      Swal.fire({
        title: 'Error',
        text: 'Las contraseñas no coinciden',
        icon:'error'
      })
    }
  }

}
