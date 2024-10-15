import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { map, Observable } from 'rxjs';
import { Cat } from '../models/classes/cat';

@Injectable({
  providedIn: 'root'
})
export class CatService {

  url = `${environment.API}/cat/breeds`;

  constructor(private http: HttpClient) { }

  getAllBreeds(): Observable<Cat[]>{
    const url = this.url;
    return this.http.get<Cat[]>(url).pipe(map<any, any>((data) => data.data));
  }
  getBreedById(breedId: string): Observable<Cat>{
    const url = `${this.url}/${breedId}`
    return this.http.get<Cat>(url).pipe(map<any, any>((data) => data.data));
  }
  getBreedsBySearch(search: string): Observable<Cat[]>{
    const url = `${this.url}/search`;
    let params = new HttpParams().set('search', search);
    return this.http.get<Cat[]>(url, {params}).pipe(map<any, any>((data) => data.data));
  }
}
