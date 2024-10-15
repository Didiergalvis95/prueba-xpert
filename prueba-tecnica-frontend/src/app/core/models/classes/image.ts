import { Cat } from "./cat";

export class Image {
    breeds: Cat[];
    id: string;
    url: string;
    width: number;
    height: number;

    constructor() {
        this.breeds = [];
        this.id = '';
        this.url = '';
        this.width = 0;
        this.height = 0;
      }
}

