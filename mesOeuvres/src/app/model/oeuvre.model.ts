import { Exposition } from "./exposition.model";
import { Image } from "./image.model";

export class Oeuvre {
  idOeuvre?: number;
  titre?: string;
  artiste?: string;
  dateCreation?: Date;
  categorie?: string;
  dimensions?: string;
  description?: string;
  prix?: number;
  exposition!: Exposition;
  image!: Image;
  imageStr!: string;

  images!: Image[];
}
