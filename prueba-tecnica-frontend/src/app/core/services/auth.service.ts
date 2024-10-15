import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Login } from '../models/interfaces/login';
import { Register } from '../models/interfaces/register';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  url = `${environment.API}/auth`;

  constructor(private http: HttpClient,
              private router: Router) { }

  login(login: Login): Observable<any>{
    const url = `${this.url}/login`
    return this.http.post<any>(url, login).pipe(map<any, any>((data) => data.data));
  }

  register(register: Register) : Observable<any>{
    const url = `${this.url}/register`
      return this.http.post<any>(url, register);
  }

  storeToken(token: string) {
    localStorage.setItem('jwt_token_b', token);
  }

  getToken(): string | null {
    return localStorage.getItem('jwt_token_b');
  }

  logout() {
    localStorage.removeItem('jwt_token_b');
  }

  isAuthenticated(): boolean {
    this.router.navigate(['/login']);
    return !!this.getToken();
  }
}
