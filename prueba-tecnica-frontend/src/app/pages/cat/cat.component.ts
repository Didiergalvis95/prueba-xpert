import { Component, OnInit, TrackByFunction } from '@angular/core';
import { Cat } from 'src/app/core/models/classes/cat';
import { Image } from 'src/app/core/models/classes/image';
import { CatService } from 'src/app/core/services/cat.service';
import { ImageService } from 'src/app/core/services/image.service';
import Swal, { SweetAlertIcon } from 'sweetalert2';

@Component({
  selector: 'app-cat',
  templateUrl: './cat.component.html',
  styleUrls: ['./cat.component.css']
})
export class CatComponent implements OnInit{
  cats: Cat[] = [];
  images: Image[] = [];
  cat: Cat = new Cat();
  constructor(private catService: CatService,
              private imageService: ImageService){
  }
  
  ngOnInit() {
    this.getAllBreeds();
  }

  getAllBreeds(){
    this.catService.getAllBreeds()
      .subscribe({
        next: (data: Cat[]) => {
          this.cats = data;
        },
        error: (error) => {
          this.openAlert('error','Error', error.error.message );
        }
      });
  }

  onSelectCat(event: Event): void {
    const selectElement = event.target as HTMLSelectElement;
    const selectedCat = this.cats.find(cat => cat.id === selectElement.value);

    if (selectedCat) {
        this.cat = selectedCat;
        this.getImagesByBreedId(selectedCat.id);
    }
  }

  getImagesByBreedId(breedId: string){
    this.imageService.getImagesByBreedId(breedId)
      .subscribe({
        next: (data: Image[]) => {
          this.images = data;
          
        },
        error: (error) => {
          this.openAlert('error','Error', error.error.message );
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
