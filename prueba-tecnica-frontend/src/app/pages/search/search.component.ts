import { Component } from '@angular/core';
import { Cat } from 'src/app/core/models/classes/cat';
import { CatService } from 'src/app/core/services/cat.service';
import Swal, { SweetAlertIcon } from 'sweetalert2';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  cats: Cat[] = [];
  catSearch: Cat[] = [];
  searchQuery: string = '';
  constructor(private catService: CatService){
  }
  ngOnInit(){
    this.getAllBreeds();
  }

  getAllBreeds(){
    this.catService.getAllBreeds()
      .subscribe({
        next: (data: Cat[]) => {
          this.cats = data;
          this.catSearch = data;
        },
        error: (error) => {
          console.error('Error:', error);
        }
      });
  }

  onSearch(searchQuery: string) {
    this.catService.getBreedsBySearch(searchQuery)
    .subscribe({
      next: (data: Cat[]) => {
        if(data.length === 0){
          this.openAlert('warning', 'Sin Información', 'No se encontraron resultados para la búsqueda');
          this.cats = this.catSearch;
        }else{
          this.cats = data;
        }
      },
      error: (error) => {
        this.openAlert('error', 'Error', error.error.message);
      }
    })
  }

  openAlert(icon: SweetAlertIcon, title: string, message: string){
    Swal.fire({
      icon: icon,
      title: title,
      text: message,
      confirmButtonText: 'Aceptar'
    })
  }

}
