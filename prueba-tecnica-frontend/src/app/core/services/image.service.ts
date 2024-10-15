import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Image } from '../models/classes/image';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  url = `${environment.API}/images`;

  constructor(private http: HttpClient) { }

  getImagesByBreedId(breedId:string): Observable<Image[]>{
    const url = `${this.url}/${breedId}`
    return this.http.get<Image[]>(url).pipe(map<any, any>((data) => data.data));
  }
}
