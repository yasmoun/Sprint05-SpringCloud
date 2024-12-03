import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';
import { Oeuvre } from '../model/oeuvre.model';
import { Exposition } from '../model/exposition.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ExpositionWrapper } from '../model/ExpositionWrapped.model';
import { Image } from '../model/image.model';
import { apiURL } from '../../../config';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class OeuvreService {
  oeuvres: Oeuvre[] = [];
  oeuvre!: Oeuvre;
  expositions: Exposition[] = [];

  apiURLExp: string = 'http://localhost:8080/oeuvres/exp';

  constructor(private http: HttpClient, private authService: AuthService) {}

  listeOeuvre(): Observable<Oeuvre[]> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.get<Oeuvre[]>(apiURL + '/all', {
      headers: httpHeaders
    });
  }

  supprimerOeuvre(id: number) {
    const url = `${apiURL}/deloeuv/${id}`;
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.delete(url, { headers: httpHeaders });
  }
  ajouterOeuvre(oeuv: Oeuvre): Observable<Oeuvre> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.post<Oeuvre>(apiURL + '/addoeuv', oeuv, {
      headers: httpHeaders,
    });
  }

  /* supprimerOeuvre(oeuv: Oeuvre) {
    //supprimer le produit prod du tableau produits
    const index = this.oeuvres.indexOf(oeuv, 0);
    if (index > -1) {
      this.oeuvres.splice(index, 1);
    }
    //ou Bien
      this.produits.forEach((cur, index) => {
         if(prod.idProduit === cur.idProduit) {
               this.produits.splice(index, 1);
            }
      });
  }*/

  consulterOeuvre(id: number): Observable<Oeuvre> {
    const url = `${apiURL}/getbyid/${id}`;
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.get<Oeuvre>(url, { headers: httpHeaders });
  }

  updateOeuvre(prod: Oeuvre): Observable<Oeuvre> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.put<Oeuvre>(apiURL + '/updateoeuv', prod, {
      headers: httpHeaders,
    });
  }

  trierOeuvres() {
    this.oeuvres = this.oeuvres.sort((n1, n2) => {
      if (n1.idOeuvre! > n2.idOeuvre!) {
        return 1;
      }
      if (n1.idOeuvre! < n2.idOeuvre!) {
        return -1;
      }
      return 0;
    });
  }

  listeExpositions(): Observable<ExpositionWrapper> {
    let jwt = this.authService.getToken();
    jwt = 'Bearer ' + jwt;
    let httpHeaders = new HttpHeaders({ Authorization: jwt });
    return this.http.get<ExpositionWrapper>(this.apiURLExp, {
      headers: httpHeaders,
    });
  }

  consulterExposition(id: number): Exposition {
    return this.expositions.find((exp) => exp.idExposition == id)!;
  }

  rechercherParExposition(idExposition: number): Observable<Oeuvre[]> {
    const url = `${apiURL}/oeuvsExp/${idExposition}`;
    return this.http.get<Oeuvre[]>(url);
  }

  rechercherParTitre(titre: string): Observable<Oeuvre[]> {
    const url = `${apiURL}/oeuvresByTitle/${titre}`;
    return this.http.get<Oeuvre[]>(url);
  }

  uploadImage(file: File, filename: string): Observable<Image> {
    const imageFormData = new FormData();
    imageFormData.append('image', file, filename);
    const url = `${apiURL + '/image/upload'}`;
    return this.http.post<Image>(url, imageFormData);
  }
  loadImage(id: number): Observable<Image> {
    const url = `${apiURL + '/image/get/info'}/${id}`;
    return this.http.get<Image>(url);
  }

  uploadImageOeuv(file: File, filename: string, id?: number): Observable<any> {
    const imageFormData = new FormData();
    imageFormData.append('image', file, filename);
    const url = `${apiURL + '/image/uploadImageOeuv'}/${id}`;
    return this.http.post(url, imageFormData);
  }

  supprimerImage(id: number) {
    const url = `${apiURL}/image/delete/${id}`;
    return this.http.delete(url, httpOptions);
  }
}
