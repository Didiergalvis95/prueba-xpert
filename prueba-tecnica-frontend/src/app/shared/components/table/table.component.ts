import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Cat } from 'src/app/core/models/classes/cat';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnChanges{
  @Input() cats: Cat[] = [];
  currentPage: number = 1;
  itemsPerPage: number = 5;
  totalPages: number = 0;
  pagesArray: number[] = [];

  constructor(){
  }
  ngOnChanges(changes: SimpleChanges): void {
    this.totalPages = Math.ceil(this.cats.length / this.itemsPerPage);
    this.updatePagesArray();
  }

  paginatedCats(): Cat[] {
    const startIndex = (this.currentPage - 1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.cats.slice(startIndex, endIndex);
  }

  changePage(page: number): void {
    if (page >= 1 && page <= this.totalPages) {
      this.currentPage = page;
      this.updatePagesArray();
    }
  }

  updatePagesArray(): void {
    const maxVisiblePages = 3;
    let startPage = Math.max(1, this.currentPage - 1);
    let endPage = Math.min(this.totalPages, this.currentPage + 1);

    if (this.currentPage === 1) {
      endPage = Math.min(maxVisiblePages, this.totalPages);
    } else if (this.currentPage === this.totalPages) {
      startPage = Math.max(1, this.totalPages - maxVisiblePages + 1);
    }

    this.pagesArray = Array(endPage - startPage + 1).fill(0).map((x, i) => i + startPage);
  }

}
